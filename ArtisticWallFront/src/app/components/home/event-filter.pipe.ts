import { PipeTransform, Pipe } from '@angular/core';
import { EventDto } from 'src/app/models/eventDto';

@Pipe({
    name : 'myfilter'
})

export class myfilterPipe implements PipeTransform {
transform(evente : EventDto [], searchText : string) : EventDto []{
 
    if (!evente || !searchText){
     return evente;
    }

    return evente.filter(event =>
        event.categoriesDto.toLocaleLowerCase().indexOf(searchText.toLocaleLowerCase()) !== -1);
}
}