ArrayList=function(/* array? */arr){
	 var items=[];
	 if(arr) items=items.concat(arr);
	 this.count=items.length;
	 this.add=function(/* object */obj){
	  items.push(obj);
	  this.count=items.length;
	 };
	 this.addRange=function(/* array */a){
	  if(a.getIterator){
	   var e=a.getIterator();
	   while(!e.atEnd()){
	    this.add(e.get());
	   }
	   this.count=items.length;
	  }else{
	   for(var i=0; i<a.length; i++){
	    items.push(a[i]);
	   }
	   this.count=items.length;
	  }
	 };
	 this.clear=function(){
	  items.splice(0, items.length);
	  this.count=0;
	 };
	 this.clone=function(){
	  return new dojox.collections.ArrayList(items); // dojox.collections.ArrayList
	 };
	 this.contains=function(/* object */obj){
	  for(var i=0; i < items.length; i++){
	   if(items[i] == obj) {
	    return true; // bool
	   }
	  }
	  return false; // bool
	 };
	 this.forEach=function(/* function */ fn, /* object? */ scope){
	  dojo.forEach(items, fn, scope);
	 };
	 this.get = function(index) {
	  return items[index];
	 };
	 this.size = function() {
	  return items.length;
	 };
	 this.getIterator=function(){
	  return new dojox.collections.Iterator(items); // dojox.collections.Iterator
	 };
	 this.indexOf=function(/* object */obj){
	  for(var i=0; i < items.length; i++){
	   if(items[i] == obj) {
	    return i; // int
	   }
	  }
	  return -1; // int
	 };
	 this.insert=function(/* int */ i, /* object */ obj){
	  items.splice(i,0,obj);
	  this.count=items.length;
	 };
	 this.item=function(/* int */ i){
	  return items[i]; // object
	 };
	 this.remove=function(/* object */obj){
	  var i=this.indexOf(obj);
	  if(i >=0) {
	   items.splice(i,1);
	  }
	  this.count=items.length;
	 };
	 this.removeAt=function(/* int */ i){
	  items.splice(i,1);
	  this.count=items.length;
	 };
	 this.reverse=function(){
	  items.reverse();
	 };
	 this.sort=function(/* function? */ fn){
	  if(fn){
	   items.sort(fn);
	  }else{
	   items.sort();
	  }
	 };
	 this.setByIndex=function(/* int */ i, /* object */ obj){
	  items[i]=obj;
	  this.count=items.length;
	 };
	 this.toArray=function(){
	  return [].concat(items);
	 }
	 this.toString=function(/* string */ delim){
	  return items.join((delim||","));
	 };
	};
    function bobImageDelete(arridxnum){
		  data.shift();
	  }
	  function getImage(img1_2_3, bob_image){		
		document.getElementById(img1_2_3).src = "/FashionPossible/product/images/" + bob_image;		
		result_img = bob_image;
		bobImageDelete(0);
	  }    
	  var imgtemp, result_img;
	  function choice1(bob_images) {
		  ++cnt;
		  imgtemp = document.getElementById("img1").src;		  
		  // if(! (cnt <= 5) ) return;
		  if(! (cnt <= 5) ){ bobTop() ; return; }	  
		  shuffled_arr(data);		  
		  getImage("img2", data[0]);
	  }    
	  function choice2(bob_images) {
		  ++cnt;
		  imgtemp = document.getElementById("img2").src;		  
		  // if(! (cnt <= 5) ) return;
		  if(! (cnt <= 5) ){ bobTop(); return; }
		  shuffled_arr(data);		  
		  getImage("img1", data[0]);
	  }
	  function shuffled_map(array){
			let shuffled = array
			  .map(a => ([Math.random(),a]))
			  .sort((a,b) => a[0]-b[0])
			  .map(a => a[1])
	  }
	  function shuffled_arr(array){
		  array.map((el, i, arr) => {
		    let r = ~~(Math.random() * arr.length);
		    arr[i] = arr[r];
		    arr[r] = el;
		    return arr;
		  })[0];
	  }	  
	  
	  