<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN\" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <title>Ежедневник - PlanNote</title>
        <meta charset="utf-8">
        <script type="text/javascript" src="grid.js"></script>
        <link rel="stylesheet" href="grid.css">
    </head>
    <body>
    <%!String study = "Учеба";
       String studyComputerScience = "Computer Science";
       String studyComputerScienceGeneralComputerScience = "General Computer Science";
       String studyComputerScienceGeneralComputerScience1 = "АСД";
       String studyComputerScienceGeneralComputerScience2 = "ОМ+НЗ";
       String studyComputerScienceGeneralComputerScience3 = "ОПJ";
       String studyComputerScienceGeneralComputerScience4 = "ШМ";
       String studyJavaDevelopment = "Java-разработка";

       String sport = "Спорт";
       String sportFootball = "Футбол";
       String sportFootball1 = "ВСКБН";
       String getSportFootball2 = "ТВМ";
    %>
    <fieldset>
        <p>Дата <input type="date" id="date" name="date"/> </p>

        <p> Направление
        <select id="direction" >
            <optgroup label=<%=study%>>
                <option value="1"><%=studyComputerScience%></option>
                <option value="2"><%=studyJavaDevelopment%></option>
            </optgroup>
            <optgroup label=<%=sport%>>
                <option value="3"><%=sportFootball%></option>
            </optgroup>
        </select>
        </p>

        <p>Комментарий</p>
        <textarea id="text" cols="35" rows="10"></textarea>
        <p><button type="submit" id="btn_write">Записать</button></p>
    </fieldset>

    <script type="text/javascript" src="prototype.js" src="jquery.js"></script>
    <script>


        function btnWriteClicked(){
            new Ajax.Request('http://localhost:8090/WebProject1/FirstServlet', {
                method:'get',
                onSuccess: function(transport) {
                    var response = transport.responseText || "no response text";
                    alert("Success! \n\n" + response);
                },
                parameters: {date: $F('date'), direction: $F('direction'), comment: $F('text')}
            });
        }

        document.observe('dom:loaded',
        function () {
            Event.observe('btn_write', 'click', btnWriteClicked);
        }
        );

        var dataset = [
            {
                "id": 0,
                "a": 1,
                "b": "Linwood Long long long",
                "c": "Petersen",
                "d": "Dahlgreen Place"
            },
            {
                "id": 1,
                "a": 2,
                "b": "Edenburg",
                "c": "Agnes",
                "d": "Gem Street"
            },
            // more columns
        ];

        var grid = new dhx.Grid('dataset');
        grid.data.load(dataset);


    </script>
    </body>
</html>
