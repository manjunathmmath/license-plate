<%@ include file="common/header.jsp" %>
<body>
<%@ include file="common/navigation.jsp" %>
<br />
<br />
<br />
<div class="container">
    <div class="row col-md-8 offset-md-2">
        <div class="card">

            <!-- success message -->
            <c:if test="${not empty param.success}">
                <div class="alert alert-info">
                    You've successfully registered to our app!
                </div>
            </c:if>

            <div class="card-header">
                <h2 class="text-center">Regsiter</h2>
            </div>
            <div class="card-body">

                <form:form method="post"
                           action="${pageContext.request.contextPath}/register/save"
                           modelAttribute="user"
                           role="form">

                    <!-- First Name -->
                    <div class="form-group mb-3">
                        <label class="form-label" for="firstName">First Name</label>
                        <form:input path="firstName"
                                    id="firstName"
                                    cssClass="form-control"
                                    placeholder="Enter first name" />
                        <form:errors path="firstName" cssClass="text-danger" />
                    </div>

                    <!-- Last Name -->
                    <div class="form-group mb-3">
                        <label class="form-label" for="lastName">Last Name</label>
                        <form:input path="lastName"
                                    id="lastName"
                                    cssClass="form-control"
                                    placeholder="Enter last name" />
                        <form:errors path="lastName" cssClass="text-danger" />
                    </div>

                    <!-- Email -->
                    <div class="form-group mb-3">
                        <label class="form-label" for="email">Email</label>
                        <form:input path="email"
                                    id="email"
                                    cssClass="form-control"
                                    type="email"
                                    placeholder="Enter email address" />
                        <form:errors path="email" cssClass="text-danger" />
                    </div>

                    <!-- Password -->
                    <div class="form-group mb-3">
                        <label class="form-label" for="password">Password</label>
                        <form:password path="password"
                                       id="password"
                                       cssClass="form-control"
                                       placeholder="Enter password" />
                        <form:errors path="password" cssClass="text-danger" />
                    </div>

                    <!-- Submit + Login link -->
                    <div class="form-group mb-3">
                        <button class="btn btn-primary" type="submit">Register</button>
                        <span>
                            Already registered?
                            <a href="${pageContext.request.contextPath}/login">Login here</a>
                        </span>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
