 // to declare variables - let, const & var(avoid using this)
 let counter = 0;
 // function is created using function keyword
 function increment() {
     counter++;
     displayCounterToUI()
 }
 function decrement() {
     counter--;
     displayCounterToUI()
 }
 function displayCounterToUI() {
     let ele = document.getElementById('a'); // <div id = 'a'>
     // to add the content we will use innerHTML property
     // <div id = 'a'>Counter = counterValue</div>
     ele.innerHTML = 'Counter = '+counter; 
 }