// initialize SVG.js
var input = {};
input.start = {
	label : "Infopark kochi",
	}
input.end = {
	label : "Munnar",
	}
input.locations = [
	{
		id:1,
		label:'Start',
		type: 'view point',
		circleType:'big',
		link: 'http://www.facebook.com',
		timeToTravel: '3.30',
		timeSpent:'1.00'
	},
	{
		id:2,
		heading:'Neriamangalam Bridge',
		type: 'view point',
		circleType:'milestone',
		link: 'http://www.facebook.com',
		timeToTravel: '3.30',
		timeSpent:'1.00'
	},
	{
		id:3,
		heading:'Cheyampara Waterfalls',
		type: 'food',
		circleType:'milestone',
		link: 'http://www.facebook.com',
		timeToTravel: '3.30',
		timeSpent:'1.00'
	},
	{
		id:4,
		heading:'Adimaly Eastern Curry poweder plant',
		type: 'food',
		circleType:'milestone',
		link: 'http://www.facebook.com',
		timeToTravel: '3.30',
		timeSpent:'1.00'
	},
	{
		id:2,
		heading:'Munnar tea estate',
		type: 'food',
		circleType:'big',
		link: 'http://www.facebook.com',
		timeToTravel: '3.30',
		timeSpent:'1.00'
	}
]

var config = {
	border:50,
	totalWidth: 1000,
	roadWidth: 20,
	roadDotWidth:3,
	bigCircle: 100,
	milestoneCircle:30,
	circleSpacing:200,
	bigCircleBorder: '#d62102',
	bigCircleFill:'#f47742',
	milestoneCircleBorder: '#d62102',
	milestoneCircleFill:'#f47742',
	roadColor:'#000',
	roadDotsColor:'#fff',
	chartName: 'timeline',
	connectorTileWidth:400,
	connectorTileHeight:250,
	connectorTileHeadingHeight:50,
	connectorTileImageWidth:100,
	connectorTileBorder:10
}

var positions = ["left","right"];
var milestoneCount = 0;
var constructCanvas = function() {
	var canvasHeight = 0;
	var canvasWidth = 0;
	//adding borders
	canvasHeight += config.border*2;
	canvasWidth += config.border*2;
	
	canvasWidth += config.totalWidth;
	
	var locations = input.locations;
	
	for(var i=0;i<input.locations.length;i++){
		if (locations[i].circleType == 'big') {
			canvasHeight += config.bigCircle;
			canvasHeight += config.circleSpacing;
		}
		if (locations[i].circleType == 'milestone') {
			canvasHeight += config.milestoneCircle;
			canvasHeight += config.circleSpacing;
		}
	}
	//removing the last spacing
	canvasHeight -= config.circleSpacing;
	
	draw = SVG(config.chartName).size(canvasWidth, canvasHeight);
	
}
var constructRoad = function() {
	var totalLength = 0;
	var locations = input.locations;
	
	for(var i=0;i<input.locations.length;i++){
		if (locations[i].circleType == 'big') {
			totalLength += config.bigCircle;
			totalLength += config.circleSpacing;
		}
		if (locations[i].circleType == 'milestone') {
			totalLength += config.milestoneCircle;
			totalLength += config.circleSpacing;
		}
	}
	totalLength -= config.circleSpacing;
	var mainline = draw.line(0, 0, 0, totalLength);
	mainline.stroke({ color: config.roadColor, width: config.roadWidth, linecap: 'butt' });
	var dottedLine = draw.line(0, 0, 0, totalLength);
	dottedLine.stroke({ color: config.roadDotsColor, width: config.roadDotWidth, linecap: 'butt', dasharray:'5,5' });
	var road = draw.group();
	road.add(mainline);
	road.add(dottedLine);
	var startx = (config.totalWidth/2)  + config.border;
	road.move(startx, config.border);
	
}

var constructConnector = function(dotX, dotY,pos) {
	
	var connectorTile = draw.rect(config.connectorTileWidth, config.connectorTileHeight);
	connectorTile.attr({
		  fill: config.milestoneCircleFill
		, 'fill-opacity': 1.0
		, stroke: config.milestoneCircleBorder
		, 'stroke-width': 2
		, cx: 0
		, cy: 0
		});
	var connectorGroup = draw.group();
	
	connectorGroup.add(connectorTile);
	if(pos == 'left') {
		var newXPosition = config.totalWidth/2+config.border - config.milestoneCircle/2 - config.border;
		var connectorLine = draw.line(config.connectorTileWidth,config.connectorTileHeight/2,newXPosition, config.connectorTileHeight/2);
		connectorLine.stroke({ color: config.milestoneCircleBorder, width: 4, linecap: 'butt' });
		connectorGroup.add(connectorLine);
		connectorGroup.move(config.border, dotY-(config.connectorTileHeight/2));
	}
	if(pos == 'right') {
		var xposition = config.border + config.totalWidth - config.connectorTileWidth;
		var connectorLine = draw.line(0,config.connectorTileHeight/2,0-((config.totalWidth/2 - config.connectorTileWidth - config.milestoneCircle/2)), config.connectorTileHeight/2);
		connectorLine.stroke({ color: config.milestoneCircleBorder, width: 4, linecap: 'butt' });
		connectorGroup.add(connectorLine);
		connectorGroup.move(xposition, dotY-(config.connectorTileHeight/2));
	}
	
	var headingText = draw.text(function(add) {
					  add.tspan('Lorem ipsum dolor sit amet tterercef dfdff').newLine()
					  add.tspan('consectetur').fill('#f06')
					  add.tspan('.')
					  add.tspan('Cras sodales imperdiet auctor.').newLine().dx(20)
					  add.tspan('Nunc ultrices lectus at erat').newLine()
					  add.tspan('dictum pharetra elementum ante').newLine()
					});
	headingText.attr({
		x:config.connectorTileBorder,
		font-size:40,
		font-family:
	});
	connectorGroup.add(headingText);
	
}
var constructDots = function() {
	var locations = input.locations;
	
	/*var start = draw.circle(100).attr({
		  fill: '#f47742'
		, 'fill-opacity': 1.0
		, stroke: '#d62102'
		, 'stroke-width': 2
		, cx: 0
		, cy: 0
		});
		var startGroup = draw.group();
		startGroup.add(start);
		var xposition = (config.totalWidth/2) + config.border;
		var yposition = config.border + 50;
		startGroup.move(xposition, yposition);*/
	
	var xposition = (config.totalWidth/2) + config.border;
	var yposition = config.border;
	for(var i=0;i<input.locations.length;i++){
		if (locations[i].circleType == 'big') {
		var eachDots = draw.circle(config.bigCircle).attr({
		  fill: config.bigCircleFill
		, 'fill-opacity': 1.0
		, stroke: config.bigCircleBorder
		, 'stroke-width': 2
		, cx: 0
		, cy: 0
		});
		yposition +=config.bigCircle/2;
		var eachDotGroup = draw.group();
		eachDotGroup.add(eachDots);
		eachDotGroup.move(xposition, yposition);
		yposition +=config.bigCircle/2;
			
		}
		if (locations[i].circleType == 'milestone') {
		var eachDots = draw.circle(config.milestoneCircle).attr({
		  fill: config.milestoneCircleFill
		, 'fill-opacity': 1.0
		, stroke: config.milestoneCircleBorder
		, 'stroke-width': 2
		, cx: 0
		, cy: 0
		});
		yposition +=config.milestoneCircle/2;
		var eachDotGroup = draw.group();
		eachDotGroup.add(eachDots);
		eachDotGroup.move(xposition, yposition);
		milestoneCount++;
		constructConnector(xposition, yposition,positions[milestoneCount%2]);
		yposition +=config.milestoneCircle/2;
		}
		yposition += config.circleSpacing;
		
		
	}
}
var draw;
var constructChart = function() {
	constructCanvas();
	constructRoad();
	constructDots();
}
constructChart();
/*var startx = 400;
var starty = 20;

var calculateHeight = function() {
	var totalNodes = input.locations.length + 2;
	return totalNodes*200;
}
var draw = SVG('timeline').size(800, calculateHeight());

var line1 = draw.line(0, 0, 0, calculateHeight()-50);
line1.stroke({ color: '#000', width: 15, linecap: 'round' });

var line2 = draw.line(0, 0, 0, calculateHeight()-50);
line2.stroke({ color: '#fff', width: 2, linecap: 'butt', dasharray:'5,5' });

var road = draw.group();
road.add(line1);
road.add(line2);
road.move(startx, starty);

var start = draw.circle(120).attr({
  fill: '#f47742'
, 'fill-opacity': 1.0
, stroke: '#d62102'
, 'stroke-width': 2
, cx: 0
, cy: 50
});*/

/*var startText = draw.text(input.start.label);
startText.attr({
	'text-anchor': 'middle',
	'x': '50%',
	'y': '50%',
});*/

/*var startGroup = draw.group();
startGroup.add(start);
startGroup.move(startx, starty);


var end = draw.circle(120).attr({
  fill: '#f47742'
, 'fill-opacity': 1.0
, stroke: '#d62102'
, 'stroke-width': 2
, cx: 0
, cy: 50
});*/

/*var startText = draw.text(input.start.label);
startText.attr({
	'text-anchor': 'middle',
	'x': '50%',
	'y': '50%',
});*/

/*var endGroup = draw.group();
endGroup.add(end);
endGroup.move(startx, calculateHeight()-40);*/

