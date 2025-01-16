import Card from 'react-bootstrap/Card';
import CardTitle from 'react-bootstrap/esm/CardTitle';

function RecepieCardTitle({ title}) {
  return (
    <Card className='RecepieCardComponent RecepieCardTitle'>
      <Card.Body>
        <h3>{ title }</h3>
      </Card.Body>
    </Card>
  );
}

export default RecepieCardTitle;