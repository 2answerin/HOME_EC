import React, { useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import Bottom from '../include/Bottom'
import Header from '../include/Header'
import Workouts from '../workout/Workouts'

const WorkoutPage = ({authLogic, workouts, onIncrement, onDecrement, onDelete, onAdd}) => {
  // const {authLogic, workouts, onIncrement} = props
  const navigate = useNavigate()//화면전환에 필요
  const onLogout = () => {
    console.log('WorkoutPage 호출')
    authLogic.logout()
  }
  const handleIncrement = (item) => {
  //자바스크립트는 같은 이름의 함수를 여러개 정의할 수 없음
  //item은 어디서 왔어?
    console.log('item은 바로 '+item)
  //상위 컴포넌트(App.jsx)의 함수를 호출하는 코드
  //WorkoutPage의 props에 App에서 선언된 workout로 주소번지를 가지고 있는데
  //왜 여기서는 처리를 못하고 다시 상위 컴포넌트로 미루는걸까
  //setItems 훅을 사용할 수 없기 때문에..
  //setItems는 파라미터로 넘기지 않습니다.
  // 왜냐하면 해당 컴포넌트가 화면 렌더링과 관련된 함수라서
    onIncrement(item);
  }
  const handleDecrement = (item) => {
    onDecrement(item)
      
  }
  const handleDelete = (item) => {
    onDelete(item)
      
  }
  const handleAdd = (name) => {
    //부모에 정의된 함수 호출하기 - 파라미터 값은 AddFrom에서 inputRef로 설정된 값 가져옴
    onAdd(name)
      
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
      <Header onLogout={onLogout} />
          <Workouts workouts={workouts}
          onIncrement={handleIncrement}
          onDecrement={handleDecrement}
          onAdd={handleAdd}
          onDelete={handleDelete}/>
        <Bottom />
    </>
    )
  }
  
  export default WorkoutPage
