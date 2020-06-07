package com.qsd.bookstore.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qsd.bookstore.dao.CommodityDao;
import com.qsd.bookstore.dao.RecordDao;
import com.qsd.bookstore.dao.ShopDao;
import com.qsd.bookstore.dao.UserDao;
import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.po.Record;
import com.qsd.bookstore.po.User;
import com.qsd.bookstore.service.ShopService;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月4日
 */
@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private RecordDao recordDao;
	@Autowired
	private CommodityDao commodityDao;

	@Override
	public int addShop(String shopName, int commodity_id) {
		Integer result = shopDao.queryShopByCommodityId(shopName, commodity_id);
		if (result != null) {
			return -1;
		}else {
			return shopDao.addShop(shopName, commodity_id);
		}
	}

	@Override
	public List<Commodity> getAll(User user) {
		String shopName = user.getShopName();
		List<Commodity> commodities = shopDao.queryAll(shopName);
		return commodities;
	}

	@Override
	public boolean removeCommodity(User user, int commodityId) {
		String shopName = user.getShopName();
		int result = shopDao.removeCommodityById(shopName, commodityId);
		return result > 0;
	}

	@Override
	@Transactional
	public int buyCommodity(HttpServletRequest request, int commodityId) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			String username = user.getUsername();
			String shopName = user.getShopName();
			String recordName = user.getRecordName();
			Double balance = user.getBalance();
			//1. 查询图书价格
			Double price = commodityDao.queryPriceById(commodityId);
			//2. 从余额中扣除价格
			balance = balance - price;
			if (balance > 0) {
				//获取记录表，查看是否购买过
				Integer isBuy = recordDao.queryRecordByCommodityId(recordName, commodityId);
				if (isBuy == null) {
					//3. 更新余额
					userDao.updateBalance(username, balance);
					//4. 从购物车中删除商品
					shopDao.removeCommodityById(shopName, commodityId);
					//5. 加入到记录表中
					Record record = new Record(recordName, commodityId, new Timestamp(System.currentTimeMillis()));
					recordDao.addRecord(record);
					//6. 更新余额
					User queryUser = userDao.queryUser(username);
					//7. 商品销售额加一
					commodityDao.addNumber(commodityId);
					session.setAttribute("user", queryUser);
					return 1;
				}else {
					return 2;
				}
			}else {
				return 0;			
			}
		}else {
			return -1;
		}
	}
	
}
