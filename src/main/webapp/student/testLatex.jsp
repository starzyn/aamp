<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/2
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="true" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>练习 - AAMP</title>
    <link rel="icon" href="/aamp/favicon.png" type="image/x-ico">
    <meta name="author" content="starzyn">
    <link href="/aamp/css/bootstrap.min.css" rel="stylesheet">
    <link href="/aamp/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/aamp/css/style.min.css" rel="stylesheet">
    <style type="text/css">
        #pdf-wrapper{
            margin: 3px;
            height: 780px;
            overflow: scroll;
            text-align: center;
        }

        .editor-wrapper{
            height: 730px;
            overflow: scroll;
        }

        #editor{
            width: 100%;
            height: 100%;
        }
    </style>
</head>

<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <jsp:include page="left.jsp" />
        <jsp:include page="header.jsp" />

        <!--页面主要内容-->
        <main class="lyear-layout-content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="card">
                            <div class="card-header bg-cyan">
                                <h4>Latex 编辑器</h4>
                                <button onclick="run()" type="button" class="btn btn-w-lg btn-success" style="position: absolute;right: 18px;top: 10px;"><i class="mdi mdi-play-circle">提交运行</i></button>
                            </div>
                            <div class="card-body editor-wrapper">
<pre id="editor">
\documentclass{article}
\begin{document}
Hello World.
\end{document}
</pre>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6" id="">
                        <div class="card">
                            <div class="card-body" id="pdf-wrapper"></div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <!--End 页面主要内容-->
    </div>
</div>

<script type="text/javascript" src="/aamp/js/jquery.min.js"></script>
<script type="text/javascript" src="/aamp/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/aamp/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="/aamp/js/main.min.js"></script>
<!-- latex 相关的包 -->
<script type="module">
    import latexjs from "https://cdn.jsdelivr.net/npm/latex.js/dist/latex.component.esm.js"
    customElements.define('latex-js', latexjs)
</script>

<!-- 编辑器相关的包 -->
<script src="/aamp/js/ace.js" type="text/javascript" charset="utf-8"></script>
<script src="/aamp/js/ext-language_tools.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    // ace.require("ace/ext/language_tools");
    var editor = ace.edit("editor");
    // editor.setOptions()
    // editor.setTheme("ace/theme/twilight");
    // editor.session.setMode("ace/mode/javascript");
    function run(){
        //获取编辑器中的代码
        var codes = editor.getValue();
        var latexArea = document.getElementById("pdf-wrapper");
        latexArea.innerHTML='<latex-js baseURL="https://cdn.jsdelivr.net/npm/latex.js@0.11.1/dist/">'
            +codes+
            '</latex-js>';
        // alert(codes);
    }
</script>
</body>
</html>
