
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
    </header>

    <section class="login-page">
      <h2>Zaloguj się</h2>
      <form method="post" action="/login">

        <div class="form-group">
          <input type="email" name="username" placeholder="Email" />
          <form:errors path="email"/>
        </div>
        <div class="form-group">
          <input type="password" name="password" placeholder="Hasło" />
          <form:errors path="password"/>
          <a href="/remind/password" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>
        <div class="form-group--buttons">
          <a href="/register" class="btn btn--without-border">Załóż konto</a>
          <c:if test="${not empty param.error}">
            <h>Złe dane!</h>
          </c:if>
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          <button class="btn" type="submit">Zaloguj się</button>
        </div>
      </form>
    </section>

<%@ include file="/WEB-INF/views/footer.jsp" %>