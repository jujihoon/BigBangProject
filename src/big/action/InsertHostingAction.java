package big.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;

import java.io.File;

import big.control.ActionForWard;
import big.dao.bigDao;
import big.model.RoomBean;
import big.model.RoomdateBean;
import big.model.RoominfoBean;
import big.model.RoomoptionBean;

public class InsertHostingAction implements Action {
	private String path;
	private boolean redirect;
	

	public InsertHostingAction() {
		super();
	}

	public InsertHostingAction(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}

	/*
	 * img_file_h/room_intro/// //// ///
	 */
	@Override
	public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {

		String confirm = "n";
		String pathFile = "C:\\workspace\\jspModel2\\Project_BigBang151130\\WebContent\\upload\\house\\";
		RoomBean roomBean = new RoomBean();
		RoominfoBean roominfoBean = new RoominfoBean();
		RoomoptionBean roomoptionBean = new RoomoptionBean();
		RoomdateBean roomdateBean = new RoomdateBean();
		try {
			if (FileUpload.isMultipartContent(request)) {
				DiskFileUpload fileUplad = new DiskFileUpload();
				fileUplad.setSizeMax(1048576 * 10);// 10MB
				fileUplad.setRepositoryPath(pathFile);
				int img_cnt=0;
				List<FileItem> list = fileUplad.parseRequest(request);
				String fileTemp = "";
				
				for (int i = 0; i < list.size(); i++) {
					FileItem fileItem = list.get(i);
					String name = fileItem.getFieldName();
					if (name.equals("img_cnt")) {
						img_cnt=Integer.parseInt(fileItem.getString("EUC-KR"));
					}
					if (name.equals("userno_h")) {
						roomBean.setUserno(Integer.parseInt(fileItem.getString("EUC-KR")));
					}
					if (name.equals("img_file_h")) {
						roomBean.setRimage(fileItem.getString("EUC-KR"));
					}
					if (name.equals("rlocation_h")) {
						roomBean.setRlocation(fileItem.getString("EUC-KR"));
						//ex3 = fileItem.getString("EUC-KR");
					}
					if (name.equals("aclass_h")) {
						roomoptionBean.setAclass(fileItem.getString("EUC-KR"));
						//ex4 = fileItem.getString("EUC-KR");
					}
					if (name.equals("bclass_h")) {
						roomoptionBean.setBclass(fileItem.getString("EUC-KR"));
						//ex5 = fileItem.getString("EUC-KR");
					}
					if (name.equals("cclass_h")) {
						roomoptionBean.setCclass(fileItem.getString("EUC-KR"));
						//ex6 = fileItem.getString("EUC-KR");
					}
					if (name.equals("dclass_h")) {
						roomoptionBean.setDclass(fileItem.getString("EUC-KR"));
						//ex7 = fileItem.getString("EUC-KR");
					}
					if (name.equals("eclass_h")) {
						roomoptionBean.setEclass(fileItem.getString("EUC-KR"));
						//ex8 = fileItem.getString("EUC-KR");
					}
					if (name.equals("rtitle")) {
						roomBean.setRtitle(fileItem.getString("EUC-KR"));
						//ex9 = fileItem.getString("EUC-KR");
					}
					if (name.equals("rmemo")) {
						roomBean.setRmemo(fileItem.getString("EUC-KR"));
						//ex10 = fileItem.getString("EUC-KR");
					}
					if (name.equals("rprice")) {
						roomBean.setRprice(fileItem.getString("EUC-KR"));
						//ex11 = fileItem.getString("EUC-KR");
					}
					if (name.equals("rcount")) {
						roominfoBean.setRcount(Integer.parseInt(fileItem.getString("EUC-KR")));
						//ex12 = fileItem.getString("EUC-KR");
					}
					if (name.equals("toilet")) {
						roominfoBean.setToilet(Integer.parseInt(fileItem.getString("EUC-KR")));
						//ex13 = fileItem.getString("EUC-KR");
					}
					if (name.equals("badroom")) {
						roominfoBean.setBadroom(Integer.parseInt(fileItem.getString("EUC-KR")));
						//ex14 = fileItem.getString("EUC-KR");
					}
					if (name.equals("checkin")) {
						roominfoBean.setCheckin(fileItem.getString("EUC-KR"));
						//ex15 = fileItem.getString("EUC-KR");
					}
					if (name.equals("checkout")) {
						roominfoBean.setCheckout(fileItem.getString("EUC-KR"));
						//ex16 = fileItem.getString("EUC-KR");
					}
					if (name.equals("roomtype")) {
						roominfoBean.setRoomtype(fileItem.getString("EUC-KR"));
						//ex17 = fileItem.getString("EUC-KR");
					}
					if (name.equals("checkindate")) {
						roomdateBean.setCheckindate(fileItem.getString("EUC-KR"));
						//ex18 = fileItem.getString("EUC-KR");
					}
					if (name.equals("checkoutdate")) {
						roomdateBean.setCheckoutdate(fileItem.getString("EUC-KR"));
						//ex19 = fileItem.getString("EUC-KR");
					}
				}
				
				String imgaddr[]=new String[img_cnt];
				for (int i = 1; i <= img_cnt; i++) {
					imgaddr[i-1]="img_"+i;
					System.out.println("imgaddr의 값 : "+imgaddr[i-1]);
				}
				
				for (int i = 0; i < list.size(); i++) {
					FileItem fileItem = list.get(i);
					String name = fileItem.getFieldName();
					for (int j = 0; j < imgaddr.length; j++) {
						if(j+1 != imgaddr.length&&name.equals(imgaddr[j+1])){
							File file = new File(pathFile + fileItem.getName());
							fileItem.write(file);
						}
					}
				}
				
				int roomno=bigDao.addRoomno(); //다오에서 가져오기
				roomBean.setRoomno(roomno);//디비에서 가져오기
				roominfoBean.setRoomno(roomno);
				roomdateBean.setRoomno(roomno);
				roomoptionBean.setRoomno(roomno);
				
				roomBean.setConfirm(confirm);
				roomBean.setRranking(0);
				roominfoBean.setSrno(bigDao.addSrno());//다오에서 가져오기
				roomdateBean.setRdno(bigDao.addRdno());//다오에서 가져오기
				roomoptionBean.setOptionno(bigDao.addOptionno());//다오에서 가져오기
				
				System.out.println(roomBean);
				System.out.println(roominfoBean);
				System.out.println(roomdateBean);
				System.out.println(roomoptionBean);
				bigDao.insertSroominfo(roomBean);
				bigDao.insertSrinfo(roominfoBean);
				bigDao.insertRoomdate(roomdateBean);
				bigDao.insertSroption(roomoptionBean);
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertHostingAction Error");
		}


		return new ActionForWard(path, redirect);
	}
}
