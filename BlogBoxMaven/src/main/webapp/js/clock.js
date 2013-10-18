function startTime()
{
var currentDate=new Date();

var h=currentDate.getHours();
var m=currentDate.getMinutes();
var s=currentDate.getSeconds();

m=checkTime(m);
s=checkTime(s);
document.getElementById('clock').innerHTML=h+":"+m+":"+s;
t=setTimeout(function(){startTime();},500);
}

function checkTime(i)
{
if (i<10)
  {
  i="0" + i;
  }
return i;
}

function showDate()
{
    var currentDate=new Date();
    
    var day=currentDate.getDay();
    var month=currentDate.getMonth();
    var year=currentDate.getFullYear();
    clearTimeout(t);
    document.getElementById('clock').innerHTML=day+"/"+month+" "+year;
    
}