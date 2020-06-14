package com.qsd.bookstore.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qsd.bookstore.dao.CommodityDao;
import com.qsd.bookstore.dao.RecordDao;
import com.qsd.bookstore.dao.ShopDao;
import com.qsd.bookstore.dao.UserDao;
import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.po.Global;
import com.qsd.bookstore.po.Record;
import com.qsd.bookstore.po.User;
import com.qsd.bookstore.service.ShopService;
import com.qsd.bookstore.util.JwtUtil;

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
	@Autowired
	private Global global;

	@Override
	public int addShop(String username, int commodity_id) {
		User user = userDao.queryUser(username);
		String shopName = user.getShopName();
		Boolean status = commodityDao.queryCommodityStatus(commodity_id);
		if (status != null) {
			if (status) {
				Integer result = shopDao.queryShopByCommodityId(shopName, commodity_id);
				if (result != null) {
					return -1;
				}else {
					return shopDao.addShop(shopName, commodity_id);
				}
			}else {
				//商品下架
				return -2;
			}
		}else {
			//没有商品
			return -3;
		}
	}

	@Override
	public List<Commodity> getAll(User user) {
		String shopName = user.getShopName();
		List<Commodity> commodities = shopDao.queryAll(shopName);
		return commodities;
	}

	@Override
	public boolean removeCommodity(String token, int commodityId) {
		String username = JwtUtil.getUsername(token);
		User user = userDao.queryUser(username);
		String shopName = user.getShopName();
		int result = shopDao.removeCommodityById(shopName, commodityId);
		return result > 0;
	}

	@Override
	@Transactional
	public int buyCommodity(String token, int commodityId) {
		String username = JwtUtil.getUsername(token);
		User user = userDao.queryUser(username);
		if (user != null) {
			Boolean status = commodityDao.queryCommodityStatus(commodityId);
			if (status != null && status) {
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
						//7. 商品销售额加一
						commodityDao.addNumber(commodityId);
						//书籍销售量加一
						global.addCommoditySellNum();
						return 1;
					}else {
						return 2;
					}
				}else {
					return 0;			
				}
			} else if (status == null) {
				//商品不存在
				return -2;
			} else {
				//商品已下架
				return -3;
			}
		}else {
			return -1;
		}
	}

	@Override
	public List<Commodity> getAllByUsername(String username) {
		User user = userDao.queryUser(username);
		return shopDao.queryAll(user.getShopName());
	}
	
}
