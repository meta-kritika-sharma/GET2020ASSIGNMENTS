// Drwas graphs on page load using morris
console.log("into js");
function onPageLoad() {
    Morris.Line({
        element: 'overview',
        data: [{
            y: "2009",
            a: 0,
            b: 0,
            c: 0
        }, {
            y: "2010",
            a: 150,
            b: 30,
            c: 50
        }, {
            y: "2011",
            a: 20,
            b: 50,
            c: 150
        }, {
            y: "2012",
            a: 150,
            b: 80,
            c: 40
        }, {
            y: "2013",
            a: 20,
            b: 110,
            c: 150
        }, {
            y: "2014",
            a: 50,
            b: 150,
            c: 40
        }, {
            y: "2015",
            a: 150,
            b: 170,
            c: 130
        }],
        xkey: 'y',
        ykeys: ['a','b','c'],
        labels: ["Series A", "Series B", "Series C"],
        hideHover: "auto",
        gridLineColor: "#eef0f2",
        resize: true,
        lineColors:  ["#007BFF", "#00bcd2", "#e785da"]
    });

    Morris.Donut({
        element: 'revenue',
        data: [{
            label: "USA",
            value: 12
        }, {
            label: "Canada",
            value: 30
        }, {
            label: "London",
            value: 20
        }],
        resize: true,
        colors: ["#40a4f1", "#5b6be8", "#c1c5e2"]
    });

    Morris.Area({
        element: 'network',
        pointSize: 3,
        lineWidth: 2,
        data: [{
            y: "2011",
            a: 10,
            b: 15
        }, {
            y: "2012",
            a: 30,
            b: 35
        }, {
            y: "2013",
            a: 10,
            b: 25
        }, {
            y: "2014",
            a: 55,
            b: 45
        }, {
            y: "2015",
            a: 30,
            b: 20
        }, {
            y: "2016",
            a: 40,
            b: 35
        }, {
            y: "2017",
            a: 10,
            b: 25
        }, {
            y: "2018",
            a: 25,
            b: 30
        }],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ["Series A", "Series B"],
        resize: true,
        hideHover: "auto",
        gridLineColor: "#eef0f2",
        lineColors: ["#00c292", "#03a9f3"],
        lineWidth: 0,
        fillOpacity: .1,
        xLabelMargin: 10,
        yLabelMargin: 10,
        grid: false,
        axes: false,
        pointSize: 0
    });
}