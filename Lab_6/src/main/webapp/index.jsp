<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<form method="Get">
    <h1>Students search</h1>
    <button type="submit" formaction="getAll">Get all records</button><br>
    <label>
        Get phonetics by performer:
        <input type="text" name="performer" placeholder="Performer">
    </label>
    <button type="submit" formaction="getByPerformer">Find</button><br>
    <label>
        Get phonetics by album:
        <input type="number" max="10" min="0" step="0.01" name="album" placeholder="Album">
    </label>
    <button type="submit" formaction="getByAlbum">Find</button><br>
</form>
</body>
</html>
