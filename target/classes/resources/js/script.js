/**
 * 
 */

// draw a pie chart segment
function DrawPieChartSegment(canvas, context, arcSize, colour, startingAngle) {
    context.save();
    var centerX = Math.floor(canvas.width / 2)
    var centerY = Math.floor(canvas.height / 2)
    var radius = Math.floor(canvas.width / 2)
 
    var endingAngle = startingAngle + arcSize
 
    context.beginPath()
    context.moveTo(centerX, centerY)
    context.arc(centerX, centerY, radius, startingAngle, endingAngle, false)
    context.closePath()
 
    context.fillStyle = colour
    context.fill()
 
    context.restore() 
}

//Pie chart of current election result
function updateCanvasLeft(pieDetail, totalVotes) {
    const canvas = document.getElementById("canvas")
    const ctx = canvas.getContext('2d')
    ctx.clearRect(0, 0, canvas.width, canvas.height)
    
    var arcSizes = []
    var colours = []
    
    pieDetail = JSON.parse(pieDetail)
    for (var i=0; i< pieDetail.length; i++) {
       var candidateResult = pieDetail[i]
       // Angle required in radians for segment
       arcSizes[i] = (candidateResult[1] * (360 / totalVotes)) * Math.PI/180
       // Colour for segment
       colours[i] = candidateResult[0]
    }
  
    var startingAngle = 270 * Math.PI/180
    for (var i=0; i<arcSizes.length; i++) {
       DrawPieChartSegment(canvas, ctx, arcSizes[i], colours[i], startingAngle)
       startingAngle += arcSizes[i]
    }  
}


//Pie chart of current election result
function updateCanvasRight(pieDetail2, totalVotes2) {
  const canvas2 = document.getElementById("canvas2")
  const ctx2 = canvas2.getContext('2d')
  ctx2.clearRect(0, 0, canvas2.width, canvas2.height)
  
  var arcSizes2 = []
  var colours2 = []

  pieDetail2 = JSON.parse(pieDetail2)
  for (var i=0; i< pieDetail2.length; i++) {
     var candidateResult2 = pieDetail2[i]
     // Angle required in radians for segment
     arcSizes2[i] = (candidateResult2[1] * (360 / totalVotes2)) * Math.PI/180
     // Colour for segment
     colours2[i] = candidateResult2[0]
  }

  var startingAngle2 = 270 * Math.PI/180
  for (var i=0; i<arcSizes2.length; i++) {
     DrawPieChartSegment(canvas2, ctx2, arcSizes2[i], colours2[i], startingAngle2)
     startingAngle2 += arcSizes2[i]
  }  
}

function handleDrag(event) {
	event.target.opacity = '0.4'	
	event.dataTransfer.setData("text", event.target.id);
}

function handleDragEnd(event) {
	event.target.opacity = '1.0'	
}

function allowDrop(event) {
    event.preventDefault();		
}

function drop(event) {
    event.preventDefault();
    var data = event.dataTransfer.getData("text");	
    window.location.href = 
    	contextPath + '/SortDrag/' + event.dataTransfer.getData("text") + '/' + event.target.id
}