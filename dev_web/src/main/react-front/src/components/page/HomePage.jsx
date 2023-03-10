import React, { useEffect } from 'react'
import { Navigate, useNavigate, useParams } from 'react-router-dom' //훅
import Bottom from '../include/Bottom'
import Header from '../include/Header'

//로그아웃 처리를 위해서 props > authLogic의 주소번지를 받아온다
const Homepage = ({authLogic}) => {
  const Navigate = useNavigate()
  let {userId} = useParams()
  console.log(userId)
  //onLogout이라는 변수가 함수 객체를 가리키고 있다 - 주소번지
  //함수가 가리키는 주소번지가 다르면 리렌더링이 일어남
  //리랜더링은 언제 발생하지?
  //state 상태가 바뀌면 - useState(0); useState({}); useState([]);
  //props 변경되었을때 - ({title, onLogout, content}) - spread operator(연산자)
  //부모 컨포넌트가 변경되었을 때 - map(n건) > item별로 row (<-컴포넌트)
  //state , props(부모 -> 자식만 가능) - 캡처링
  const onLogout = () => {
    console.log('HomePage onLogout 호출')
    authLogic.logout()
  }

  useEffect(() => {
    authLogic.onAuthChange(user => {
      if(!user){
        Navigate("/")
      }
    })
})
  return (
    <React.Fragment>
      <Header userId = {userId} onLogout = {onLogout}/>
    <div>
      HomePage 페이지
    </div>
    <Bottom/>
    </React.Fragment>
  )
}

export default Homepage