package team.waibao.dao;

import java.util.List;






import team.waibao.entity.User;

/**
 * 用户操作类
* @author 曾志鹏
* @version 创建时间：2016年8月17日 上午9:13:17
*
 */
public interface UserMapper {

	/**
	 * 添加一个用户
	 *@param user 要添加的用户
	 */
	public void addUser(User user);
	/**
	 * 根据条件查找用户
	 *@param searchingCondition 查询的条件
	 *@return
	 */
	public List<User> findUsers(User searchingCondition);
	
	/**
	 * 通过用户查找用户
	 *@param userName 用户名
	 *@return
	 */
	public User findUserByUserName(String userName);
	
	/**
	 * 通过userName 来找到用户的id，用户名在数据库里是不可重复的，所以一个用户对应一个id
	 *@param userName
	 *@return
	 */
	public int findIdByUserName(String userName);
	/**
	 * 给指定用户添加
	 *@param recruitment
	 *@param user
	 *@return
	 */
	public void updateUserAccount(User user);
	
   /**
    * 判断是否存在该用户
    *@param user 判断的对象
    *@return
    */
	public User findUserByUserNameAndPassword(User user);
	
	/**
	 * 通过用户id找到余额
	 *@param userId
	 *@return
	 */
	public double getUserAccountByUserId(int userId);
	
	

}
