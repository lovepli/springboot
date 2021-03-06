
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ECharts</title>
    <meta charset="utf-8">
    <script type="text/javascript" src="../js/jquery-1.7.js"></script>
    <%--<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=您的密钥"></script>--%>
    <%--<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=4GL6acBgozHgR4HQhhelm678yMBq6wKb"></script>--%>
    <script src="http://api.map.baidu.com/getscript?v=2.0&ak=4GL6acBgozHgR4HQhhelm678yMBq6wKb"></script>
    <%--<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=YWdGplhYjUGQ3GtpKNeuTM2S"></script>--%>
</head>

<body>

<div id="container" style="width: 1200px;height:800px;"></div>

<select id="stylelist" onchange="changeMapStyle(this.value)">
    <option value="normal">默认地图样式</option> //系统默认
    <option value="light">清新蓝风格</option> //不需要第三方库
    <option value="dark">黑夜风格</option>    //不需要第三方库
    <option value="redalert">红色警戒风格</option>
    <option value="googlelite">精简风格</option>
    <option value="grassgreen">自然绿风格</option>
    <option value="midnight">午夜蓝风格</option>
    <option value="pink">浪漫粉风格</option>
    <option value="darkgreen">青春绿风格</option>
    <option value="bluish">清新蓝绿风格</option>
    <option value="grayscale">高端灰风格</option>
    <option value="hardedge">强边界风格</option>
</select>

</body>
</html>

<script type="text/javascript">



    //数据准备
    var points = [
        {"lng":116,"lat":40,"status":1,"id":50},
        {"lng":117,"lat":31,"status":1,"id":2},
        {"lng":116,"lat":34,"status":0,"id":3},
        {"lng":118,"lat":39,"status":0,"id":4},
        {"lng":110,"lat":35,"status":1,"id":5}
    ];

    var map = new BMap.Map("container");//初始化地图
    setZoom(points);//设置中心点和缩放级别。
    addMarker(points);//把原始数据的轨迹点添加到地图上。
    map.enableScrollWheelZoom();//滚轮放大缩小


    // 更换地图背景颜色
    function changeMapStyle(style){
        var mapStyle ={
            features: ["road","building","water","land"],//隐藏地图上的"poi",
            style : style,
        };
        map.setMapStyle(mapStyle);
    }

    //根据原始数据计算中心坐标和缩放级别，并为地图设置中心坐标和缩放级别。
    function setZoom(points){
        if(points.length>0){
            var maxLng = points[0].lng;
            var minLng = points[0].lng;
            var maxLat = points[0].lat;
            var minLat = points[0].lat;
            var res;
            for (var i = points.length - 1; i >= 0; i--) {
                res = points[i];
                if(res.lng > maxLng) maxLng =res.lng;
                if(res.lng < minLng) minLng =res.lng;
                if(res.lat > maxLat) maxLat =res.lat;
                if(res.lat < minLat) minLat =res.lat;
            };
            var cenLng =(parseFloat(maxLng)+parseFloat(minLng))/2;
            var cenLat = (parseFloat(maxLat)+parseFloat(minLat))/2;
            var zoom = getZoom(maxLng, minLng, maxLat, minLat);
            map.centerAndZoom(new BMap.Point(cenLng,cenLat), zoom);
        }else{
            //没有坐标，显示全中国。
            map.centerAndZoom(new BMap.Point(103.388611,35.563611), 5);
        }
    }

    //根据经纬极值计算绽放级别。本例核心代码。
    function getZoom (maxLng, minLng, maxLat, minLat) {
        var zoom = ["50","100","200","500","1000","2000","5000","10000","20000","25000","50000","100000","200000","500000","1000000","2000000"]//级别18到3。
        var pointA = new BMap.Point(maxLng,maxLat);  // 创建点坐标A
        var pointB = new BMap.Point(minLng,minLat);  // 创建点坐标B
        var distance = map.getDistance(pointA,pointB).toFixed(1);  //获取两点距离,保留小数点后1位
        for (var i = 0,zoomLen = zoom.length; i < zoomLen; i++) {
            if(zoom[i] - distance > 0){
                return 18-i+3;//之所以会多3，是因为地图范围常常是比例尺距离的10倍以上。所以级别会增加3。
            }
        };
    }

    //在轨迹点上创建图标，并添加点击事件
    function addMarker(points){
        var point,marker;
        // 创建标注对象并添加到地图
        for(var i = 0,pointsLen = points.length;i <pointsLen;i++){
            point = new BMap.Point(points[i].lng,points[i].lat);
            marker = new BMap.Marker(point);
            map.addOverlay(marker);
        }
    }

</script>