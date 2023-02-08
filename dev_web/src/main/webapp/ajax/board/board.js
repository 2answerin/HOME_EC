//비동기통신객체를 생성해서 담을 변수 선언
let xhrObject = null;
//비동기통신객체를 생성하는 함수 구현 - 리턴예약어(void) 없어서 반환받을 수 없음
function createRequest() {
  try {
    xhrObject = new XMLHttpRequest();
  } catch (trymicrosoft) {
    try {
      //MS의 IE 사용자 위한 객체 생성
      xhrObject = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (error) {
      xhrObject = null;
    }
  }
  if (xhrObject == null) {
    alert("비동기 통신 객체 생성 에러");
  }
} // end createRequest

//span태그가 가지고 있는 텍스트 노드값을 읽어오기
function getText(el) {
  let text = "";
  if (el != null) {
    if (el.childNodes) {
      console.log(el + "," + el.childNodes.length);
      // el null스킵, undifined
      for (let i = 0; i < el.childNodes.length; i++) {
        //el.childNodes.length
        //costEl, priceEl
        var childNode = el.childNodes[i]; //el.childNodes[0], el.childNodes[1]
        //너 텍스트 노드니?
        if (childNode.nodeValue != null) {
          text = text + childNode.nodeValue;
        }
      }
    }
  }
  return text;
}
//기존 TextNode의 값을 다른 문자열로 바꾸기
/***********************************************
  param1 :document.getElementById("boardSold")
  param2 :document.getElementById("#boardSold")
  param3 :xhrObject. 
  ************************************************/
function replaceText(el, value) {
  //el -> boardSoldEl(판매량), cashEl(마진)
  if (el != null) {
    //span
    clearText(el); //기존에 있던 10을 지워주세요.
    //새로운 텍스트 노드 15를 생성하기
    var newNode = document.createTextNode(value); //15
    //위에서 생성한 텍스트 노드 값을 el에 붙이는 함수 호출하기
    el.appendChild(newNode); //el boardSoldEl
    // -> <span>10</span> <span id = boardSold or cash></span> <span>20</span>
  }
}
//기존 태그안에 문자열 지우는 함수 구현
function clearText(el) {
  if (el != null) {
    if (el.childNodes) {
      for (let i = 0; i < el.childNodes.length; i++) {
        let childNode = el.childNodes[i];
        el.removeChild(childNode); //해당 el 삭제하기 - DOM API -> 직관적 X
      }
    }
  }
}

function createRequest2() {
  try {
    xhrObject = new XMLHttpRequest(); // constructor
  } catch (trymicrosoft) {
    try {
      //MS의 IE 사용자 위한 객체 생성
      xhrObject = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (error) {
      xhrObject = null;
    }
  }
  if (xhrObject == null) {
    alert("비동기 통신 객체 생성 에러");
  }
  return xhrObject;
}
