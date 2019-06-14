<#import "./main.ftl" as main>

<@main.main>
<div class="row">
    <form class="col s12" action="/reg" method="post">
        <div class="row">
            <div class="col m8 offset-m2 s12">
                <div class="card">
                    <div class="card-content">
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="email" type="email" name="email" class="validate">
                                <label for="email">Email</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="name" type="text" name="username" class="validate">
                                <label for="name">Username</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="password" type="password" name="password" class="validate">
                                <label for="password">Password</label>
                            </div>
                        </div>
                    </div>
                    <div class="card-action">
                        <button class="btn waves-effect waves-light green darken-3" type="submit" name="action">Submit
                            <i class="material-icons right">send</i>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</@main.main>