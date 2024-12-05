import Card from 'react-bootstrap/Card';
import CardTitle from 'react-bootstrap/esm/CardTitle';

function RecepieCardTitle() {
  return (
    <Card style={{ width: '18rem' }}>
      <Card.Body>
        <CardTitle>Mama's Meaty loaf</CardTitle>
      </Card.Body>
    </Card>
  );
}

export default RecepieCardTitle;