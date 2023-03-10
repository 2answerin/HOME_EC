import React, { useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import Bottom from '../include/Bottom'
import Header from '../include/Header'

const EmpPage = ({authLogic}) => {
  const navigate = useNavigate()
  const onLogout = () => {
    console.log('EmpPage 호출')
    authLogic.logout()
  }
  useEffect(() => {
    authLogic.onAuthChange(user => {
      if(!user){
          navigate("/") 
      }
    })
})
  return (
    <>
      <Header onLogout={onLogout}/>
      사원 관리 페이지
      <Bottom />
    </>
  )
}

export default EmpPage