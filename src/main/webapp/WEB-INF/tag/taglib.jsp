<%--
  Created by IntelliJ IDEA.
  User: 41809
  Date: 2018/7/25
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="fns" uri="/WEB-INF/tag/tlds/fns.tld" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="pageUrlBook" value="/book/page?" />
<c:set var="pageUrlOrder" value="/order/page?" />
<c:set var="pageUrlAfterSale" value="/afterSale/page?" />
<c:set var="searchUrlBook" value="/book/search?" />
<c:set var="searchUrlOrder" value="/order/search?" />
<c:set var="searchUrlAfterSale" value="/afterSale/search?" />
<c:set var="deleteUrl" value="/book/delete?"/>

