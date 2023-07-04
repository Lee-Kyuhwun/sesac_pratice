<!DOCTYPE html>
<html>
<head>
  <title>Calculation Result</title>
</head>
<body>
<%
  String num1Str = request.getParameter("num1");
  String num2Str = request.getParameter("num2");

  if(num1Str != null && num2Str != null){
    int num1 = Integer.parseInt(num1Str);
    int num2 = Integer.parseInt(num2Str);
    int sum = num1 + num2;
%>
<p>The sum of <%= num1 %> and <%= num2 %> is <%= sum %>.</p>
<%
} else {
%>
<p>Please provide two numbers.</p>
<%
  }
%>
</body>
</html>
