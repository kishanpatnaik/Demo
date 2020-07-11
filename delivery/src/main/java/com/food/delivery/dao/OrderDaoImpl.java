package com.food.delivery.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.food.delivery.model.Cart;
import com.food.delivery.model.Dish;
import com.food.delivery.model.Order;
import com.food.delivery.model.Restaurant;

public class OrderDaoImpl implements OrderDao{
	
	
	
	@Override
	public List<Order> get(String username) {

		return null;
	}

	@Override
	public void save(Order order) {

		
	}

	@Override
	public void delete(String username) {

		
	}

	@Autowired
    private SessionFactory sessionFactory;
	
	public Cart updateCart(Cart cart){
		Session session = (Session) sessionFactory.getCurrentSession();
		
        return null;
	}
	
	@Override
	public List<Restaurant> findRestaurants(long location) {
		Session session = (Session) sessionFactory.getCurrentSession();
        Query<Restaurant> query = session.createQuery("from RESTAURANT where id=:ID",Restaurant.class);
        query.setParameter("ID", location);
        List<Restaurant>  restaurents = query.getResultList();
        for(Restaurant r:restaurents){
        	Query<Dish> query1 = session.createQuery("from Foods",Dish.class);
            query1.setParameter("id", location);
            List<Dish> foods = query1.getResultList();
            r.setMenu(foods);
        }
        session.close();
      	return restaurents;
	}

	@Override
	public Cart addItemToCart(List<Order> orders,String user) {

		if(!orders.isEmpty()){
			Session session = (Session) sessionFactory.getCurrentSession();	
			Query cartIdQuery = session.createQuery("select cartId from UserTable where user_name=:userName");
			String cartId = (String) cartIdQuery.getSingleResult();
			if(cartId.isEmpty() ||cartId ==null){
				Cart cart = new Cart();
				for(Order order:orders){
				cart = UpdateOrdersInCart(cart, order);
				}
				return cart;
			}else{
				Query<Order> cartQuery = session.createQuery("from Order where cartId=:cartId",Order.class);
				cartQuery.setParameter("cartId", cartId);
				List<Order> ordersInCart = cartQuery.getResultList();
				Cart cart = new Cart();
				for(Order order:orders){
				cart = UpdateOrdersInCart(cart, order);
				}
				return cart;
			}
		}else{
			return new Cart();
		}
	
	}

	@Override
	public Cart UpdateOrdersInCart(Cart cart, Order order) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(order);
		session.getTransaction().commit();
		cart.getOrders().add(order);
		return cart;
		
	}

	@Override
	public Cart getCart(String user) {
		
		Session session = (Session) sessionFactory.getCurrentSession();	
		Query cartIdQuery = session.createQuery("select cartId from UserTable where user_name=:userName");
		String cartId = (String) cartIdQuery.getSingleResult();
		
		if(cartId.isEmpty() ||cartId ==null){
			return new Cart();
		}else{
			Query<Order> cartQuery = session.createQuery("from Order where cartId=:cartId",Order.class);
			cartQuery.setParameter("cartId", cartId);
			List<Order> ordersInCart = cartQuery.getResultList();
			return new Cart(ordersInCart);
		}
	}

	@Override
	public boolean emptyCart(String userName) {
		Session session = (Session) sessionFactory.getCurrentSession();	
		Query cartIdQuery = session.createQuery("select cartId from UserTable where user_name=:userName");
		cartIdQuery.setParameter("userName", userName);
		String cartId = (String) cartIdQuery.getSingleResult();
		Query<Order> cartQuery = session.createQuery("from Order where cartId=:cartId",Order.class);
		cartQuery.setParameter("cartId", cartId);
		List<Order> ordersInCart = cartQuery.getResultList();
		for(Order order:ordersInCart){
			session.delete(order);
			ordersInCart.remove(order);
		}
		return ordersInCart.isEmpty();
	}

	@Override
	public List<Dish> getMenu(int restaurantId) {
		Session session = (Session) sessionFactory.getCurrentSession();	
		Query menuQuery = session.createQuery("from Restaurant where id=:id");
		menuQuery.setParameter("id", restaurantId);
		List<Dish> menu = menuQuery.getResultList();
		return menu;
	}
	
}
