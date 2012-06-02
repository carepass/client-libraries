describe("positioningHelper", function() {
 
	    /*   y-axis (x = 0)							  -------->+ 
    	 *    |                                  |
		 *                                       |    (right is positive for x-axis)
		 *      		                         |    (down is positive for y-axis)
		 *     /\  /\  /\                        v		  
		 *    |a ||b ||c | --- x-axis (y = 0)          +       
		 *   /\\//\\//\\/
		    |d ||e ||f | 
		 *   \//\\//\\//\	 	   
		 *    |g ||h ||i |    
	     *     \/  \/  \/     
		 *
		 *  if w = "width of hex image" and l = "length of a hexagon side" then
		 * a=(0.5w, 0) , b=(1.5w, 0)     , c=(2.5w,0) 
		   d=(0,1.5l)   , e=(w,1.5l), f=(2w,1.5l)
		   g=(0.5, 3l) , h=(1.5w, 3l)    , i=(2.5w, 3l)
		 */ 
		     
	var centerPoints = {
	 a:{x:0,y:0},b:{x:0,y:0},c:{x:0,y:0},
	 d:{x:0,y:0},e:{x:0,y:0},f:{x:0,y:0},
	 g:{x:0,y:0},h:{x:0,y:0},i:{x:0,y:0}
	};
	
	function setAToI(hexInfo)
	{ 
     //set the center points according the key above
	 centerPoints.a.x = (hexInfo.halfHexWidth);
	 centerPoints.b.x = (hexInfo.width + hexInfo.halfHexWidth);
	 centerPoints.c.x = ((2 * hexInfo.width) + hexInfo.halfHexWidth);
	 centerPoints.d.y = (hexInfo.sidelength + hexInfo.halfSideLength);
	 centerPoints.e.x = (hexInfo.width); centerPoints.e.y = (hexInfo.sidelength + hexInfo.halfSideLength);
	 centerPoints.f.x = ((2 * hexInfo.width)); centerPoints.f.y = (hexInfo.sidelength + hexInfo.halfSideLength);
	 centerPoints.g.x = (hexInfo.halfHexWidth); centerPoints.g.y = (3 * hexInfo.sidelength);
	 centerPoints.h.x = (hexInfo.width + hexInfo.halfHexWidth); centerPoints.h.y = (3 * hexInfo.sidelength);
	 centerPoints.i.x = ((2 * hexInfo.width) + hexInfo.halfHexWidth); centerPoints.i.y = (3 * hexInfo.sidelength);
	}
	
	var positionhelper;
	beforeEach(function () {
	  //reset positionhelper for each test
      positionhelper = BodyAtlas.UI.PlaquePositioningHelper;		
    });

   it("should return the centerpoint when points are within the hexagon E", function() {
       	
    	var hexObjectInfo = {
    	 width: 32,
		 halfHexWidth: 16,
    	 sidelength: 16,    	 
    	 halfSideLength: 8
        };	
       
	   positionhelper.init(hexObjectInfo);
	   setAToI(hexObjectInfo);
	   
	   var pointWithinHexE = {x:30, y:22};
	   var point2WithinHexE = {x:34, y:26};
	   var closestCenter = positionhelper.GetNearestHexCenter(pointWithinHexE.x, pointWithinHexE.y);
	   expect(closestCenter).toEqual(centerPoints.e);
	   var closestCenter = positionhelper.GetNearestHexCenter(point2WithinHexE.x, point2WithinHexE.y);
	   expect(closestCenter).toEqual(centerPoints.e);
	});		 	
	
   it("should return center e when point touches e, g and h ", function() {
   
         /*	 /\\//\\//\
		    |d ||e ||f | 
		 *   \//\\//\\/
		 *    |g ||h |
	     *     \/  \/ 
		 
		 
		 point = (w, 2.5l)
		 e=(w,1.5l) g=(0.5w, 3l) , h=(1.5w, 3l) 
		 distance between e an point = (w-w)^2 + (2.5l - 1.5l)^2 = l^2 (D1)
		 distance between g an point = (0.5w-w)^2 + (3l - 2.5l)^2 = 0.25 w^2 +  0.25 l^2 (D2)
		 distance between h an point = (1.5w - w)^2 + (3l - 2.5l)^2 = 0.25 w^2 +  0.25 l^2 (D2)
		 */
		 
    	var hexObjectInfo = {
    	 width: 32,
		 halfHexWidth: 16,
    	 sidelength: 16,    	 
    	 halfSideLength: 8
        };	
		       
	   positionhelper.init(hexObjectInfo);
	   setAToI(hexObjectInfo);
	   /*
	     D1 = 256 
	     D2 = 320		 
		 so the the point is closest to e		 
		*/	   	   
	   var pointOnEdge = {x:hexObjectInfo.width, y:(2 * hexObjectInfo.sidelength)+ hexObjectInfo.halfSideLength};
	   var closestCenter = positionhelper.GetNearestHexCenter(pointOnEdge.x, pointOnEdge.y);
	   expect(closestCenter).toEqual(centerPoints.e);	   
	});		 	
	
	 it("should return either g or h when point touches e, g and h for weird hex parameters ", function() {
   
         /*	 /\\//\\//\
		    |d ||e ||f | 
		 *   \//\\//\\/
		 *    |g ||h |
	     *     \/  \/ 
		 
		 
		 point = (w, 2.5l)
		 e=(w,1.5l) g=(0.5w, 3l) , h=(1.5w, 3l) 
		 distance between e an point = (w-w)^2 + (2.5l - 1.5l)^2 = l^2 (D1)
		 distance between g an point = (0.5w-w)^2 + (3l - 2.5l)^2 = 0.25 w^2 +  0.25 l^2 (D2)
		 distance between h an point = (1.5w - w)^2 + (3l - 2.5l)^2 = 0.25 w^2 +  0.25 l^2 (D2)
		 */
		 
    	var hexObjectInfo = {
    	 width: 40,
		 halfHexWidth: 20,
    	 sidelength: 26,    	 
    	 halfSideLength: 13
        };	
		       	
	   positionhelper.init(hexObjectInfo);
	   setAToI(hexObjectInfo);
	   /*
		 D1 = 676	   
	     D2 = 569
		 so the the point is closest to G or H
		*/	   	   
	   var pointOnEdge = {x:hexObjectInfo.width, y:(2 * hexObjectInfo.sidelength)+ hexObjectInfo.halfSideLength};	        
	   var closestCenter = positionhelper.GetNearestHexCenter(pointOnEdge.x, pointOnEdge.y);	   
	   //expect(closestCenter).toEqual(centerPoints.h) ||expect(closestCenter).toEqual(centerPoints.g);	 
	   var centerIsEitherGOrH = (closestCenter.x == centerPoints.g.x && closestCenter.y == centerPoints.g.y) || (closestCenter.x == centerPoints.h.x && closestCenter.y == centerPoints.h.y);
	   expect(centerIsEitherGOrH).toBeTruthy();
	});		 	

});
