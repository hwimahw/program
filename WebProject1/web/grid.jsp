<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Quick start with dhtmlxGrid</title>
    <link rel="STYLESHEET" type="text/css" href="/home/mansur/IdeaProjects/WebProject1/web/codebase
/dhtmlxgrid.css">
    <script src="/codebase/dhtmlxgrid.js"></script>
</head>
<body>
<div id="gridbox" style="width:600px;height:400px;"></div>
<script>
    var mygrid = new dhtmlXGridObject("gridbox");

    //the path to images required by grid
    mygrid.setHeader("Sales,Book title,Author,Price");//the headers of columns
    mygrid.setInitWidths("100,250,150,100");          //the widths of columns
    mygrid.setColAlign("right,left,left,left");       //the alignment of columns
    mygrid.setColTypes("ro,ed,ed,ed");                //the types of columns
    mygrid.setColSorting("int,str,str,int");          //the sorting types
    mygrid.init();      //finishes initialization and renders the grid on the page
</script>
</body>
</html>