import Card from 'react-bootstrap/Card';
import CardText from 'react-bootstrap/esm/CardText';

function RecepieCardDescription({description}) {
  
  return (
    
    <Card className='RecepieCardComponent RecepieCardDescription'>
      <Card.Body>
        <CardText>
        {description}
        </CardText>
      </Card.Body>
    </Card>
  );
}

export default RecepieCardDescription;