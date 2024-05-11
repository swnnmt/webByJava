//--------------------Thao tác chọn chi tiết sản phẩm---------------
const baoquan=document.querySelector(".baoquan");
const chitiet=document.querySelector(".chitiet");
const gioithieu=document.querySelector(".gioithieu");
const checkClick=document.querySelectorAll(".click");
    checkClick.forEach(function(check, index){
        check.addEventListener("click",function(){
            remove();
            check.classList.add("active");
        })
    })
   
function remove(){
    const checkActive=document.querySelector(".active");
    checkActive.classList.remove("active");
}
if(baoquan){
    baoquan.addEventListener("click",function(){
        document.querySelector(".product-content-right-bottom-content-gioithieu").style.display="none";
        document.querySelector(".product-content-right-bottom-content-chitiet").style.display="none";
        document.querySelector(".product-content-right-bottom-content-baoquan").style.display="block";
    })
}
if(chitiet){
    chitiet.addEventListener("click",function(){
        document.querySelector(".product-content-right-bottom-content-gioithieu").style.display="none";
        document.querySelector(".product-content-right-bottom-content-baoquan").style.display="none";
        document.querySelector(".product-content-right-bottom-content-chitiet").style.display="block";
    })
}
if(gioithieu){
    gioithieu.addEventListener("click",function(){
        document.querySelector(".product-content-right-bottom-content-gioithieu").style.display="block";
        document.querySelector(".product-content-right-bottom-content-baoquan").style.display="none";
        document.querySelector(".product-content-right-bottom-content-chitiet").style.display="none";
    })
}
//----------------------
const detail =document.querySelector(".product-content-right-bottom-top");
detail.addEventListener("click" ,function(){
    const unDetail= document.querySelector(".product-content-right-bottom-content-big");
    unDetail.classList.toggle("detail");
})