
<!-- page script -->
<script src="/Qorder/script/fallingsnow_v6.js"></script>
<script type="text/javascript">
    $(function() {
        startTime();
        $(".center").center();
        $(window).resize(function() {
            $(".center").center();
        });
    });

    /*  */
    function startTime()
    {
        var today = new Date();
        var h = today.getHours();
        var m = today.getMinutes();
        var s = today.getSeconds();

        // add a zero in front of numbers<10
        m = checkTime(m);
        s = checkTime(s);

        //Check for PM and AM
        var day_or_night = (h > 11) ? "PM" : "AM";

        //Convert to 12 hours system
        if (h > 12)
            h -= 12;

        //Add time to the headline and update every 500 milliseconds
        $('#time').html(h + ":" + m + ":" + s + " " + day_or_night);
        setTimeout(function() {
            startTime()
        }, 500);
    }

    function checkTime(i)
    {
        if (i < 10)
        {
            i = "0" + i;
        }
        return i;
    }

    /* CENTER ELEMENTS IN THE SCREEN */
    jQuery.fn.center = function() {
        this.css("position", "absolute");
        this.css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) +
                $(window).scrollTop()) - 30 + "px");
        this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) +
                $(window).scrollLeft()) + "px");
        return this;
    }
</script>
<style type="text/css">
#index
{
	position:fixed;
	bottom: 0px;
	right:0px;
	height:170px;
	width:170px;
}
#logout
{
	float:right;
	top:0px;
	right:0px;
	font-size:20px;
	color:white;
}
#header
{
	font-family:impact; 
	font-size:40px; 
	color:white; 
	text-align: center;
	display: table; 
	margin-left: auto; 
	margin-right: auto;
}
#snowflakeContainer {
    position: absolute;
    left: 0px;
    top: 0px;
}
.snowflake {
    padding-left: 15px;
    font-family: Cambria, Georgia, serif;
    font-size: 14px;
    line-height: 24px;
    position: fixed;
    color: #FFFFFF;
    user-select: none;
    z-index: 1000;
}
.snowflake:hover {
    cursor: default;
}
</style>
<div id="snowflakeContainer">
    <p class="snowflake">*</p>
</div>
<link rel="shortcut icon" sizes="16x16" href="/Qorder/image/app/qorder.ico">
<link rel="shortcut icon" sizes="72x72" href="/Qorder/image/app/android.png">
<link rel="apple-touch-icon" sizes="144x144" href="/Qorder/image/app/ios.png"/>

<a href="/Qorder/login/admin/logout.do" id="logout">Logout</a><br>
<h1 id="header">Administrator Page</h1>
<i id="time" style="color:gray; font-size:24px"></i>
<img src="/Qorder/image/app/logo.png" id="index">
