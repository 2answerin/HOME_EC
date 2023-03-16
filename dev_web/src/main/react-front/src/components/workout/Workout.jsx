import React from 'react'

/* const Workout = (props) => { */
/* const {workout, onIncrement} = props => */
const Workout = ({workout, onIncrement,onDecrement,onDelete}) => {
  console.log(workout)
    const handleIncrement = () => {
      //이벤트처리가 되어있지 않고 상위 컴포넌트의 함수를 호출함
      //상위 컴포넌트의 함수는 peops를 통해서 접근 가능함
      //상위 함수를 호출할 때 파라미터도 넘어갑니다
      onIncrement(workout)
    }
    const handleDecrement = () => {
      onDecrement(workout)
    }
    const handleDelete = () => {
      onDelete(workout)
    }
  return (
    <>
    <li className = "habit">
        <span className="habit-name">{workout.name}</span> 
        <span className="habit-count">{workout.count}</span>
    <button className="habit-button habit-increase" onClick={handleIncrement}>
          <i className="fas fa-plus-square"></i>
      </button>
      <button className="habit-button habit-decrease" onClick={handleDecrement}>
          <i className="fas fa-minus-square"></i>
      </button>
      <button className="habit-button habit-delete" onClick={handleDelete}>
          <i className="fas fa-trash"></i>
      </button>
      </li>
    </>
  )
}

export default Workout