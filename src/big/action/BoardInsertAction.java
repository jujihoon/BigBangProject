package big.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;

import big.action.Action;
import big.control.ActionForWard;
import big.dao.bigDao;
import big.model.BoardBean;

public class BoardInsertAction implements Action {
	private String path;
	private boolean redirect;

	public BoardInsertAction() {
		super();
	}

	public BoardInsertAction(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}

	@Override
	public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// System.out.println("여기가 BoardInsertAction 시작");
		BoardBean bean = new BoardBean();
		System.out.println(request.getParameter("board_flag") + ">?");
		if (request.getParameter("board_flag").equals("board")) {
			try {
				bean.setNo((Integer) bigDao.getSequence());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bean.setWriter(request.getParameter("writer"));
			bean.setTitle(request.getParameter("title"));
			bean.setPass(request.getParameter("pass"));
			bean.setContents(request.getParameter("contents"));
			bean.setFileName("none");
			bean.setHit(Integer.parseInt(request.getParameter("hit")));
			bean.setRef(bean.getNo());
			bean.setStep(Integer.parseInt(request.getParameter("step")));
			bean.setLev(Integer.parseInt(request.getParameter("lev")));
			bean.setPnum(bean.getNo());
			bean.setReply(Integer.parseInt(request.getParameter("reply")));
		} else {
			String fileName = "";
			String pathFile = "C:\\workspace\\";
			String job = "";
			String flag;
			try {
				flag = request.getParameter("board_flag");
			} catch (Exception e) {
				flag = "";
				e.printStackTrace();
			}

			System.out.println("1");
			try {
				if (FileUpload.isMultipartContent(request)) {
					System.out.println("2");
					DiskFileUpload fileUplad = new DiskFileUpload();
					fileUplad.setSizeMax(1048576 * 3);// 3MB
					fileUplad.setRepositoryPath(pathFile);
					List<FileItem> list = fileUplad.parseRequest(request);
					String fileTemp = "";
					for (int i = 0; i < list.size(); i++) {
						FileItem fileItem = list.get(i);
						String name = fileItem.getFieldName();
						if (name.equals("title")) {
							bean.setTitle(fileItem.getString("EUC-KR"));
						}
						if (name.equals("writer")) {
							bean.setWriter(fileItem.getString("EUC-KR"));
						}
						if (name.equals("pass")) {
							bean.setPass(fileItem.getString("EUC-KR"));
						}
						if (name.equals("contents")) {
							bean.setContents(fileItem.getString("EUC-KR"));
							// System.out.println(bean.getContents()+" contents
							// null 뜬다.");
						}

						if (name.equals("job")) {
							job = fileItem.getString("EUC-KR");
						}

						if (job.equals("modify")) {
							if (name.equals("no")) {
								bean.setNo(Integer.parseInt(fileItem.getString("EUC-KR")));
							}
						}

						if (!fileItem.isFormField()) {// file
							File file = new File(pathFile + fileItem.getName());
							fileItem.write(file);
							bean.setFileName(fileItem.getName());
							System.out.println(bean.getFileName() + "fileName 은??");
							if (bean.getFileName() == null)
								bean.setFileName("none");
						} // if
					} // for
					if (!job.equals("modify"))
						bean.setNo((Integer) bigDao.getSequence());
					System.out.println(bean);

					if (job.equals("new")) {

						bean.setRef(bean.getNo());
						bean.setPnum(bean.getNo());
					} else if (job.equals("reply")) {
						// 1 0
						// updateStep :
						bigDao.updateStep(bean.getRef(), bean.getStep());// 반드시+1하기전에
																			// 호출해야한다
						// updateReply : 부모에 번호에 해당되는 값이 증가하고 그렇지않으면 ?
						bigDao.updateReply(job, bean.getPnum());
						bean.setStep(bean.getStep() + 1);
						bean.setLev(bean.getLev() + 1);

					} else if (job.equals("modify")) {
						System.out.println("3");
						bean.setNo(Integer.parseInt(request.getParameter("no")));
						bigDao.updateBoard(bean);
						System.out.println(bean);

						if (flag.equals("admin")) {
							path = "admin.do?cmd=adminBoard";
						} else {

							path = "boardinfo.do?cmd=boardInfo&no=" + bean.getNo() + "&job=info";
						}
						return new ActionForWard(path, redirect);
					} else {
						System.out.println("4");
						System.out.println("job = " + job);
					}
					System.out.println("5");
					System.out.println(bean);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		bigDao.insertBoard(bean);
		return new ActionForWard(path, redirect);
	}

}
