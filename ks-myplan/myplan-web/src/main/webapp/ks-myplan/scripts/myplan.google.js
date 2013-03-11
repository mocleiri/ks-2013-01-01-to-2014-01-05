var _gaq = _gaq || [];
jQuery(document).ready(function () {
    var profile;
    var subdomain = document.location.hostname.split('.')[0];

    if (subdomain.indexOf("uwksdev") != -1) { profile = "1"; }
    else if (subdomain.indexOf("uwkseval") != -1) { profile = "2"; }
    else if (subdomain.indexOf("uwkstrn") != -1) { profile = "3"; }
    else if (subdomain.indexOf("uwksprod") != -1 || subdomain.indexOf("uwstudent") != -1) {
        if (!jQuery("#applicationUser").data("adviser")) { profile = "4"; } // Students analytics profile
        else { profile = "5"; } // Advisers analytics profile
    }

    _gaq.push(['_setAccount', 'UA-33432259-' + profile]);
    _gaq.push(['_setDomainName', 'washington.edu']);
    _gaq.push(['_trackPageview']);

    (function () {
        var ga = document.createElement('script');
        ga.type = 'text/javascript';
        ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0];
        s.parentNode.insertBefore(ga, s);
    })();
});