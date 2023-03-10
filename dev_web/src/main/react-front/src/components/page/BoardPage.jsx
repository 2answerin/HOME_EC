import React, { useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import Bottom from '../include/Bottom'
import Header from '../include/Header'

const BoardPage = ({authLogic}) => {
  //Single Page Application 컨벤션을 위한 훅
  const navigate = useNavigate()//화면전환에 필요
  const onLogout = () => {
    console.log('BoardPage 호출')
    authLogic.logout()
  }

  useEffect(() => {
    authLogic.onAuthChange(user => { //authLogic.js 호출 - 상태가 바뀌면 
      if(!user){
          navigate("/")  //페이지 이동
      }
    })
})
  return (
    <>
    <Header onLogout={onLogout}/>
      BoardPage
    <Bottom/>
    </>
  )
}

export default BoardPage
