import Card from 'react-bootstrap/Card';
import CardTitle from 'react-bootstrap/esm/CardTitle';

function RecepieCardImage() {
  return (
    <Card className='RecepieCardComponent RecepieCardImage'>
      <Card.Body>
      <img src="Student-recepie-app\src\assets\download.png" alt="Placholder"/>
      </Card.Body>
    </Card>
  );
}

export default RecepieCardImage;