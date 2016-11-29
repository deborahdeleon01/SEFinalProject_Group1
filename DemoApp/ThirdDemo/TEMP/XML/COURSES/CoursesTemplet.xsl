<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
<head>
<style>

  .table-title h3 {
     color: #ff8e5e;
     font-size: 30px;
     font-weight: 400;
     font-style:normal;
     font-family: "Roboto", helvetica, arial, sans-serif;
     text-shadow: -1px -1px 1px rgba(0, 0, 0, 0.1);
     text-transform:uppercase;
  }

  .table-fill {
    background: white;
    border-radius:3px;
    border-collapse: collapse;
    height: 320px;
    margin: auto;
    max-width: 600px;
    padding:5px;
    width: 100%;
    box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
    animation: float 5s infinite;
  }

  th {
    color:#D5DDE5;;
    background:#1b1e24;
    border-bottom:4px solid #9ea7af;
    border-right: 1px solid #343a45;
    font-size:23px;
    font-weight: 100;
    padding:24px;
    text-align:left;
    text-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
    vertical-align:middle;
  }

  tr {
    border-top: 1px solid #C1C3D1;
    border-bottom-: 1px solid #C1C3D1;
    color:#666B85;
    font-size:16px;
    font-weight:normal;
    text-shadow: 0 1px 1px rgba(256, 256, 256, 0.1);
  }

  tr:nth-child(odd) td {
    background:#f2d7cb;
  }

  td {
    background:#FFFFFF;
    padding:20px;
    text-align:left;
    vertical-align:middle;
    font-weight:300;
    font-size:18px;
    text-shadow: -1px -1px 1px rgba(0, 0, 0, 0.1);
    border-right: 1px solid #C1C3D1;
  }

  td:last-child {
    border-right: 0px;
  }

  th.text-left {
    text-align: left;
  }

  th.text-center {
    text-align: center;
  }

  th.text-right {
    text-align: right;
  }

  td.text-left {
    text-align: left;
  }

  td.text-center {
    text-align: center;
  }

  td.text-right {
    text-align: right;
  }

</style>
</head>
<body style="background:#D3D3D3">
<center>
<img src="../smt.png" alt="SMT College" style="width:100;height:100;"> </img>
<table class="table-fill">
<thead>
<tr>
<th class="text-left">Department</th>
<th class="text-left"><xsl:value-of select="Course/Department"/></th>
</tr>
</thead>
<tr>
<td class="text-left">Prefix</td>
<td class="text-left"><xsl:value-of select="Course/Prefix"/></td>
</tr>
<tr>
<td class="text-left">Number</td>
<td class="text-left"><xsl:value-of select="Course/Number"/></td>
</tr>
<tr>
<td class="text-left">Name</td>
<td class="text-left"><xsl:value-of select="Course/Name"/></td>
</tr>
<tr>
<td class="text-left">Description</td>
<td class="text-left"><xsl:value-of select="Course/Description"/></td>
</tr>
<tr>
<td class="text-left">Credit-hours</td>
<td class="text-left"><xsl:value-of select="Course/Credit-hours"/></td>
</tr>
<tr>
<td class="text-left">Lecture-hours</td>
<td class="text-left"><xsl:value-of select="Course/Lecture-hours"/></td>
</tr>
<tr>
<td class="text-left">Lab-hours</td>
<td class="text-left"><xsl:value-of select="Course/Lab-hours"/></td>
</tr>
<tr>
<td class="text-left">Level</td>
<td class="text-left"><xsl:value-of select="Course/Level"/></td>
</tr>
<tr>
<td class="text-left">Schedule-type</td>
<td class="text-left"><xsl:value-of select="Course/Schedule-type"/></td>
</tr>
<tr>
<td class="text-left">Prerequisite</td>
<td class="text-left"><xsl:value-of select="Course/Prerequisite"/></td>
</tr>
<tr>
<td class="text-left">Restrictions</td>
<td class="text-left"><xsl:value-of select="Course/Restrictions"/></td>
</tr>
<tr>
<td class="text-left">Course-attributes</td>
<td class="text-left"><xsl:value-of select="Course/Course-attributes"/></td>
</tr>
</table>

 </center>

</body></html>
</xsl:template>
</xsl:stylesheet>