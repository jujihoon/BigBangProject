package big.dao;

import java.util.HashMap;
import java.util.List;

//import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import big.model.BoardBean;
import big.model.ReplyBean;
import big.model.ReservationBean;
import big.model.RoomBean;
import big.model.RoomReplyBean;
import big.model.RoomdateBean;
import big.model.RoominfoBean;
import big.model.RoomoptionBean;
import big.model.UserBean;

public class bigDao {
	private static SqlSessionFactory sqlSessionFactory;

	static {
		sqlSessionFactory = big.util.ServiceUtil.getSqlSessionFactory();
	}
	public static RoomReplyBean BoardInfoReply(int roomno){
		
		
		return null;
	}

	public static void joinDao(UserBean bean) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("joinDao", bean);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}

	public static Integer selectSeq() {
		return sqlSessionFactory.openSession().selectOne("selectSeq");
	}

	public static UserBean selectIdCheck(HashMap<Object, Object> map) {
		return sqlSessionFactory.openSession().selectOne("selectIdCheck", map);
	}

	public static String selectId(String email) {
		return sqlSessionFactory.openSession().selectOne("selectId", email);
	}

	public static Object selectInfo(int no) {
		return sqlSessionFactory.openSession().selectOne("selectInfo", no);
	}
	public static String IdSearch(HashMap<Object, Object>map){
		return sqlSessionFactory.openSession().selectOne("IdSearch",map);
	}
	/* ********************Address관련******************** */
	public static List<String> addrSido(){
		return sqlSessionFactory.openSession().selectList("addrSido");
	}
	public static List<String> addrGogun(){
		return sqlSessionFactory.openSession().selectList("addrGogun");
	}
	
	/* ********************Search관련********************* */
	public static Integer RgetTotalRow(HashMap<Object, Object>map) throws Exception {
		return sqlSessionFactory.openSession().selectOne("RgetTotalRow",map);

	}
	
	public static List<RoomBean> RselectBoard(HashMap<Object, Object> map) throws Exception {

		return sqlSessionFactory.openSession().selectList("RselectBoard", map);
	}

	/* **********************Board관련************************* */
	public static List<ReplyBean> selectRePly(int infoPk) {
		return sqlSessionFactory.openSession().selectList("selectRePly", infoPk);
	}

	public static void replyAdd(ReplyBean bean) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("replyAdd", bean);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}

	public static Integer selectSequence() {
		return sqlSessionFactory.openSession().selectOne("selectSequence");
	}

	public static void updateBoard(BoardBean bean) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("updateBoard", bean);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}

	public static void deleteBoard(int no) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete("deleteBoard", no);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}

	}

	public static String getPass(int no) throws Exception {
		return sqlSessionFactory.openSession().selectOne("getPass", no);
	}

	public static Object selectBoardInfo(int no) {
		return sqlSessionFactory.openSession().selectOne("selectBoardInfo", no);
	}

	public static Object RselectBoardInfo(int roomno) {
		return sqlSessionFactory.openSession().selectOne("RselectBoardInfo", roomno);
	}
	
	
	public static void updateHit(int no) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("updateHit", no);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}

	public static List<BoardBean> selectBoard(HashMap<Object, Object> map) throws Exception {
		return sqlSessionFactory.openSession().selectList("selectBoard", map);

	}

	public static Integer getTotalRow(HashMap<Object, Object> map) throws Exception {
		return sqlSessionFactory.openSession().selectOne("getTotalRow",map);

	}

	public static void updateStep(int ref, int step) {// step은 부모의 step
		SqlSession session = sqlSessionFactory.openSession();
		try {
			HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put("ref", ref);
			map.put("step", step);
			session.update("updateStep", map);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}

	}

	public static void updateReply(String job, int pnum) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put("job", job);
			map.put("pnum", pnum);
			session.update("updateReply", map);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}

	public static void insertBoard(BoardBean bean) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("insertBoard", bean);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				session.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} finally {
			session.close();
		}

	}

	public static Integer getSequence() throws Exception {
		return sqlSessionFactory.openSession().selectOne("getSequence");
	}
	
	//admin
	public static List<UserBean> AdminselectUser(HashMap<Object, Object> map) throws Exception{
		return sqlSessionFactory.openSession().selectList("AdminselectUser",map);
	}
	public static void AdmindeleteUser(int no) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete("AdmindeleteUser", no);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}

	}
	public static Integer getTotalRowUser(HashMap<Object, Object> map) throws Exception {
		return sqlSessionFactory.openSession().selectOne("getTotalRowUser",map);

	}
	public static Object selectUserInfo(int no) {
		return sqlSessionFactory.openSession().selectOne("selectUserInfo", no);
	}
	
	public static Integer getTotalRowRoom(HashMap<Object, Object> map) throws Exception {
		return sqlSessionFactory.openSession().selectOne("getTotalRowRoom",map);
		
	}
	public static void updateUser(UserBean bean) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("updateUser", bean);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
	
	
	public static List<BoardBean> AdminselectBoard() throws Exception{
		return sqlSessionFactory.openSession().selectList("AdminselectBoard");
	}
	public static List<RoomBean> AdminselectRoom(HashMap<Object, Object> map) throws Exception{
		return sqlSessionFactory.openSession().selectList("AdminselectRoom",map);
	}
	public static void AdmindeleteRoom(int no) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete("AdmindeleteRoom", no);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}

	}

	//mypage
	public static void insertwish(HashMap<Object, Object> map) throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("insertwish",map);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
	}
	public static List<RoomBean> selectwish(int userno) throws Exception{
		return sqlSessionFactory.openSession().selectList("selectwish",userno);
	}
	public static void deletewish(int wishno) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete("deletewish", wishno);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}

	}
	
	public static Integer addRoomno() {
		// TODO Auto-generated method stub
		return sqlSessionFactory.openSession().selectOne("addRoomno");
	}	
	public static Integer addSrno(){
		return sqlSessionFactory.openSession().selectOne("addSrno");
	}
	public static Integer addRdno(){
		return sqlSessionFactory.openSession().selectOne("addRdno");
	}
	public static Integer addOptionno(){
		return sqlSessionFactory.openSession().selectOne("addOptionno");
	}
	
	public static void insertSroominfo(RoomBean bean) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("insertSroominfo", bean);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				session.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} finally {
			session.close();
		}

	}
	public static void insertSrinfo(RoominfoBean bean) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("insertSrinfo", bean);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				session.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} finally {
			session.close();
		}
		
	}
	public static void insertRoomdate(RoomdateBean bean) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("insertRoomdate", bean);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				session.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} finally {
			session.close();
		}
		
	}
	public static void insertSroption(RoomoptionBean bean) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("insertSroption", bean);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				session.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} finally {
			session.close();
		}
		
	}
	
	public static Integer addReserve() {
		// TODO Auto-generated method stub
		return sqlSessionFactory.openSession().selectOne("addReserve");
	}
	
	public static void insertReservation(ReservationBean bean) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("insertReservation", bean);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				session.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} finally {
			session.close();
		}
		
	}
	
	
	
	

}
