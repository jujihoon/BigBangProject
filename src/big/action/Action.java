package big.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import big.control.ActionForWard;

public interface Action {
   public ActionForWard execute(HttpServletRequest request,HttpServletResponse response);
}
