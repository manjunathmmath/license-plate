<%@ include file="common/header.jsp" %>
<body>
<%@ include file="common/navigation.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <!-- Error message -->
            <c:if test="${param.error eq 'true'}">
                <div class="alert alert-danger">Invalid Email and Password.</div>
            </c:if>
            <!-- Logout message -->
            <c:if test="${param.logout eq 'true'}">
                <div class="alert alert-success">You have been logged out.</div>
            </c:if>

            <div class="card">
                <div class="card-header">
                    <h3 class="text-center">Login</h3>
                </div>
                <div class="card-body">
                    <form method="post"
                          action="${pageContext.request.contextPath}/login"
                          class="form-horizontal"
                          role="form">

                        <div class="mb-3">
                            <label for="username" class="control-label">Email *</label>
                            <input type="text"
                                   id="username"
                                   name="username"
                                   class="form-control"
                                   placeholder="Email"/>
                        </div>

                        <div class="mb-3">
                            <label for="password" class="control-label">Password *</label>
                            <input type="password"
                                   id="password"
                                   name="password"
                                   class="form-control"
                                   placeholder="Password"/>
                        </div>

                        <div class="mb-3">
                            <button type="submit" class="btn btn-primary">Login</button>
                            <span>
                                Not registered?
                                <a href="${pageContext.request.contextPath}/register">Register/SignUp Here</a>
                            </span>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
