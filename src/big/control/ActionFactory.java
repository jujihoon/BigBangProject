package big.control;

import big.action.Action;
import big.action.AdminBoardAction;
import big.action.AdminBoardDelete;
import big.action.AdminBoardModify;
import big.action.AdminRoomAction;
import big.action.AdminRoomDelete;
import big.action.AdminUserAction;
import big.action.AdminUserDelete;
import big.action.AdminUserModify;
import big.action.BoardDelete;
import big.action.BoardHitAction;
import big.action.BoardInfoAction;
import big.action.BoardInsertAction;
import big.action.BoardListAction;
import big.action.BoardReplyInsertAction;
import big.action.BoardconfirmCheckAction;
import big.action.IdCheckAction;
import big.action.IdSearchAction;
import big.action.InfoModifyAction;
import big.action.InsertHostingAction;
import big.action.JoinAction;
import big.action.LoginAction;
import big.action.LogoutAction;
import big.action.MainAction;
import big.action.ReservationAction;
import big.action.RoomInfoAction;
import big.action.SearchAction;
import big.action.WishInsertAction;
import big.action.WishListAction;

public class ActionFactory {
	static ActionFactory factory;

	// 싱글턴 패턴
	public static ActionFactory getInstance() {
		if (factory == null) {
			factory = new ActionFactory();
		}
		return factory;
	}

	public Action getAction(String cmd) {
		System.out.println(cmd);
		if(cmd.equals("MainAction")){
			return new MainAction("mainPage.jsp",false);
		}
		if (cmd.equals("JoinAction")) {
			System.out.println(1);
			return new JoinAction("/Project_BigBang151130/mainPage/index.jsp", true);
		}
		if (cmd.equals("loginAction")) {
			System.out.println(2);
			return new LoginAction("#", true);
		}
		if (cmd.equals("infoModify")) {
			System.out.println(3);
			return new InfoModifyAction("mypageFolder/infoModify.jsp", false);
		}
		if (cmd.equals("idCheck")) {
			System.out.println(4);
			return new IdCheckAction("logPage/idCheck.jsp", false);
		}
		if (cmd.equals("logout")) {
			System.out.println(5);
			return new LogoutAction("/Project_BigBang151130/mainPage/index.jsp", true);
		}
		if (cmd.equals("SearchAction")) {
			System.out.println(6);
			return new SearchAction("room/room_boardPage.jsp", false);
		}
		if (cmd.equals("RoomInfoAction")) {
			System.out.println(10);
			return new RoomInfoAction("room/roomInfo_Test.jsp", false);
		}
		if(cmd.equals("IdSearch")){
			return new IdSearchAction("",false);
		}
		// BOARD--
		System.out.println(cmd);
		if (cmd.equals("bbsInsert")) {
			System.out.println(7);
			return new BoardInsertAction("boardList.do?cmd=boardList", true);
		}
		if (cmd.equals("boardList")) {
			System.out.println(8);
			return new BoardListAction("boardFolder/communityPage.jsp", false);
		}
		if (cmd.equals("hit")) {
			System.out.println(9);
			return new BoardHitAction("boardInfo.do?cmd=boardInfo", true);

		}
		if (cmd.equals("boardInfo")) {
			System.out.println(10);       
			return new BoardInfoAction("boardFolder/infoPage.jsp", false);

		}
		if (cmd.equals("confirmCheck")) {
			System.out.println(11);
			return new BoardconfirmCheckAction("", true);

		}
		if (cmd.equals("boarddelete")) {
			System.out.println(12);
			return new BoardDelete("boardList.do?cmd=boardList", true);

		}
		if (cmd.equals("replyInsert")) {
			System.out.println(13);
			return new BoardReplyInsertAction("boardInfo.do?cmd=boardInfo", true);
		}
		//방 올리기 
		if (cmd.equals("insertHostingAction")) {
			System.out.println(14);
			return new InsertHostingAction("../hostPage/hostingSuccess.jsp", false);
		}

		//admin
		if (cmd.equals("adminUser")) {
			return new AdminUserAction("adminFolder/adminUserPage.jsp", false);
		}
		if (cmd.equals("adminUserDelete")) {
			return new AdminUserDelete("admin.do?cmd=adminUser", true);
		}
		if (cmd.equals("adminUserModify")) {
			return new AdminUserModify("adminFolder/adminUserMod.jsp", false);
		}
		if (cmd.equals("adminBoard")) {
			return new AdminBoardAction("adminFolder/adminBoardPage.jsp", false);
			
		}
		if (cmd.equals("adminBoardModify")) {
			return new AdminBoardModify("adminFolder/adminBoardMod.jsp", false);
		}
		
		if (cmd.equals("adminBoardDelete")) {
			return new AdminBoardDelete("admin.do?cmd=adminBoard", false);
			
		}
		if (cmd.equals("adminRoom")) {
			return new AdminRoomAction("adminFolder/adminRoomPage.jsp", false);
			
		}
		if (cmd.equals("adminRoomDelete")) {
			return new AdminRoomDelete("admin.do?cmd=adminRoom", false);			
		}
		//MyPage
		if (cmd.equals("wishInsert")) {
			return new WishInsertAction("mainPage/index.jsp", false);
			
		}
		if (cmd.equals("wishList")) {
			return new WishListAction("wishList.jsp", false);			
		}
		
		
		if (cmd.equals("insertReservationAction")) {
			return new ReservationAction("/Project_BigBang151130/room/reserveSuccess.jsp", true);		}
		
			
		return null;

	}

}
