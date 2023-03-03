import React from 'react'
import { useParams } from 'react-router-dom' //훅
import Bottom from '../include/Bottom'
import Headers from '../include/Header'
//로그아웃 처리를 위해서 props > authLogic의 주소번지를 받아온다
const Homepage = ({authLogic}) => {
  let {userId} = useParams()
  console.log(userId)
  const onLogout = () => {
    authLogic.logout()
  }
  return (
    <React.Fragment>
      <Headers userId = {userId} onLogout = {onLogout}/>
    <div>
      HomePage 페이지
    </div>
    <Bottom/>
    </React.Fragment>
  )
}

export default Homepage