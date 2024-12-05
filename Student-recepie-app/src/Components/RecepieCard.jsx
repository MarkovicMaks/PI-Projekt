import Card from 'react-bootstrap/Card';
import RecepieCardTitle from './RecepieCardTitle';
import RecepieCardDescription from './RecepieCardDescription';
import RecepieCardTags from './RecepieCardTags';
import RecepieCardImage from './RecepieCardImage';



function RecepieCard() {
  return (
    <Card className='RecepieCard'>
      <Card.Body>
        <div className='RecepieCardTop'>
        <RecepieCardTitle />
        <RecepieCardTags />
        </div>
        <div className='RecepieCardTop'>
        <RecepieCardDescription />
        <RecepieCardImage />
        </div>
      </Card.Body>
    </Card>
  );
}

export default RecepieCard;