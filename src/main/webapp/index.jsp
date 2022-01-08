<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WEB SERVICE</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-dark navbar-dark">
    <a class="navbar-brand ml-5" href="#">WEB SERVICE</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
</nav>

<div class="bg-light">

    <section class="py-5">
        <div class="container">
            <div class="row">
                <div class="col-md-12 text-center h4">
                    We developed a set of REST APIs (RESTFul Services) capable of reading a JSON file deployed
                    on a server and returning information by using a collection of simple HTTP requests.
                </div>
            </div>
        </div>
    </section>
    <section>
        <div class="container">
            <div class="row pb-5">
                <div class="col-md-6">
                    <h2 class="text-center pb-4">User Resource</h2>
                    <div class="card m-auto" style="width: 25rem;">
                        <div class="card-body">
                            <h5 class="card-title">Get All Users</h5>
                            <p class="card-text">Get all known Twitter users included in the archive.
                                Return <span class="font-weight-bold">MediaType.APPLICATION_JSON</span></p>
                            <form action="AllUserServlet" method="GET">
                                <input class="btn btn-primary px-5 float-right" type="submit"></input>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <h2 class="text-center pb-4">Tweet Resource</h2>
                    <div class="card m-auto" style="width: 25rem;">
                        <div class="card-body">
                            <h5 class="card-title">Get All Tweets</h5>
                            <p class="card-text">Get all Tweets included in the archive. <br>
                                Return <span class="font-weight-bold">MediaType.APPLICATION_JSON</span></p>
                            <form action="AllTweetServlet" method="GET">
                                <input class="btn btn-primary px-5 float-right" type="submit"></input>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row pb-5">
                <div class="col-md-6">
                    <div class="card m-auto" style="width: 25rem;">
                        <div class="card-body">
                            <h5 class="card-title">Get User by Screen Name</h5>
                            <p class="card-text">Get detailed profile information about a given Twitter user. <br>
                                Return <span class="font-weight-bold">MediaType.APPLICATION_JSON</span></p>
                            <div class="input-group mb-3">
                                <form action="UserByScreenNameServlet" method="GET">
                                    <div class="row">
                                        <div class="col-md-7 pr-1">
                                            <input type="text" class="form-control" name="screen-name"
                                                   placeholder="User's Screen Name"
                                                   aria-label="User's Screen Name" aria-describedby="basic-addon2">
                                        </div>
                                        <div class="col-md-5 pl-1">
                                            <input class="btn btn-primary px-5" type="submit">
                                        </div>
                                    </div>
                                </form>

                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card m-auto" style="width: 25rem;">
                        <div class="card-body">
                            <h5 class="card-title">Get Tweet by ID</h5>
                            <p class="card-text">Get the details about a given tweet ID.<br>
                                Return <span class="font-weight-bold">MediaType.APPLICATION_JSON</span></p>
                            <div class="input-group mb-3">
                                <form action="TweetByIdServlet" method="GET">
                                    <div class="row">
                                        <div class="col-md-7 pr-1">
                                            <input type="text" class="form-control" name="tweetId"
                                                   placeholder="Tweet's ID"
                                                   aria-label="Tweet's ID" aria-describedby="basic-addon2">
                                        </div>
                                        <div class="col-md-5 pl-1">
                                            <input class="btn btn-primary px-5" type="submit">
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<!-- Footer -->
<footer class="page-footer font-small bg-dark">

    <!-- Copyright -->

    <div class="text-center text-white">
        <p class="footer-copyright text-center pt-3 text-white">© 2022 Copyright</p>
        <p class="text-center pb-3 text-white">Developed by Ahmed Atya & Al-Amir Hassan & Moaz Mahmoud</p>
    </div>
    <!-- Copyright -->

</footer>
<!-- Footer -->
</body>
</html>