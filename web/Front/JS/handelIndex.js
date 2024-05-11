//Bắt sự kiện lăn chuột xuống
const header= document.querySelector("header");
window.addEventListener("scroll",function(){
     x = window.pageYOffset
     if(x>0){
       header.classList.add("sticky")
     }else{
      header.classList.remove("sticky")
     }
}
)
//Chạy silde và chạy con trỏ nút theo slide
const imgPositon=document.querySelectorAll(".aspect-ratio-169 img")
const imgContainer=document.querySelector(".aspect-ratio-169")
const dotItem= document.querySelectorAll(".dot")
let index =0;
let imgNumber=imgPositon.length;
// console.log(imgPositon);
imgPositon.forEach(function(image,index){
  image.style.left=index*100+"%"
  dotItem[index].addEventListener("click",function(){
    slider(index);
  })
})
function imgSlide(){
    index++;
    if(index>=imgNumber){
        index=0;
    }
    slider(index)
}
function slider(index){
    imgContainer.style.left="-"+index*100+"%";
    const dotActive=document.querySelector(".active")
    dotActive.classList.remove("active");
    dotItem[index].classList.add("active");
}
setInterval(imgSlide,5000)
// 
const woman=document.querySelector(".woman");
const men=document.querySelector(".men");
const bayby=document.querySelector(".baby");
const checkClick=document.querySelectorAll(".click");
    checkClick.forEach(function(check, index){
        check.addEventListener("click",function(){
            remove();
            check.classList.add("active-related");
        })
    })
   
function remove(){
    const checkActive=document.querySelector(".active-related");
    checkActive.classList.remove("active-related");
}
if(woman){
    woman.addEventListener("click",function(){
        document.querySelector(".product-baby").style.display="none";
        document.querySelector(".product-men").style.display="none";
        document.querySelector(".product-woman").style.display="block";
    })
}
if(men){
    men.addEventListener("click",function(){
        document.querySelector(".product-baby").style.display="none";
        document.querySelector(".product-woman").style.display="none";
        document.querySelector(".product-men").style.display="block";
    })
}
if(bayby){
    bayby.addEventListener("click",function(){
        document.querySelector(".product-baby").style.display="block";
        document.querySelector(".product-woman").style.display="none";
        document.querySelector(".product-men").style.display="none";
    })
}
//----------------------
const detail =document.querySelector(".product-content-right-bottom-top");
detail.addEventListener("click" ,function(){
    const unDetail= document.querySelector(".product-content-right-bottom-content-big");
    unDetail.classList.toggle("detail");
})