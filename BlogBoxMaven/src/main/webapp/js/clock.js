//Gets the current Date object extracts hours minutes and seconds and sets the
// p tag in the xhtml
function startTime()
{
    var currentDate = new Date();

    var h = currentDate.getHours();
    var m = currentDate.getMinutes();
    var s = currentDate.getSeconds();

    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('clock').innerHTML = h + ":" + m + ":" + s;
    t = setTimeout(function() {
        startTime();
    }, 500);
}
//Adds a zero(0) infront of a single number to maek it two digit
function checkTime(i)
{
    if (i < 10)
    {
        i = "0" + i;
    }
    return i;
}
//Gets the current date object and extracts the day of month, month and year and
//sets the p tag in the xhtml.
function showDate()
{
    var currentDate = new Date();
    var day = currentDate.getDate();
    var month = currentDate.getMonth();
    month = month+1;
    var year = currentDate.getFullYear();
    clearTimeout(t);
    document.getElementById('clock').innerHTML = day + "/" + month + " " + year;
}