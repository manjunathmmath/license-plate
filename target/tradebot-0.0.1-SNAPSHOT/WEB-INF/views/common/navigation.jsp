<header class="py-3 mb-3 border-bottom">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
                    <use xlink:href="#bootstrap"></use>
                </svg>
            </a>

            <ul class="nav col-12 col-lg-auto my-2 justify-content-center my-md-0 text-small">
                <sec:authorize access="isAuthenticated()">
                    <li>
                        <a href="/" class="nav-link link-dark" target="_blank">
                            <i class="bi bi-house"></i>
                            License Plate Company
                        </a>
                    </li>

                    <li>
                        <a href="/pnd" class="nav-link link-dark">
                            <i class="bi bi-list"></i>
                            PND
                        </a>
                    </li>

                    <li>
                        <a href="/num" class="nav-link link-dark">
                            <i class="bi bi-list"></i>
                            NUM
                        </a>
                    </li>

                    <li>
                        <a href="/vbo" class="nav-link link-dark">
                            <i class="bi bi-list"></i>
                            VBO
                        </a>
                    </li>

                    <li>
                        <a href="/post" class="nav-link link-dark">
                            <i class="bi bi-list"></i>
                            Post
                        </a>
                    </li>
                </sec:authorize>
            </ul>
            <sec:authorize access="isAuthenticated()">
                <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
                    <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
                </form>

                <div class="dropdown text-end">
                    <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
                    </a>
                    <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1" style="">
                        <li><a class="dropdown-item" href="#">New project...</a></li>
                        <li><a class="dropdown-item" href="#">Settings</a></li>
                        <li><a class="dropdown-item" href="#">Profile</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="/logout">Sign out</a></li>
                    </ul>
                </div>
            </sec:authorize>
        </div>
    </div>
</header>
<script type="text/javascript">

</script>