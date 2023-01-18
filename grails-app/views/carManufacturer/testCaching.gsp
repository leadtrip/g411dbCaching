<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <title>Test caching</title>
</head>

<body>
    <table class="table table-bordered">
        <tr>
            <th>Action</th>
            <th>Result</th>
        </tr>
        <tr>
            <td>Data service</td>
            <td>${dataServiceResult}</td>
        </tr>
        <tr>
            <td>Read car</td>
            <td>${readCarManufacturerResult}</td>
        </tr>
        <tr>
            <td>Get car</td>
            <td>${getCarManufacturerResult}</td>
        </tr>
        <tr>
            <td>Dynamic finder</td>
            <td>${dynamicFinderResult}</td>
        </tr>
        <tr>
            <td>With criteria</td>
            <td>${criteriaResult}</td>
        </tr>
        <tr>
            <td>Create criteria</td>
            <td>${criteriaListResult}</td>
        </tr>
    </table>
</body>
</html>