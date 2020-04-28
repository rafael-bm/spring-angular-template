import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'shortName'
})
export class ShortNamePipe implements PipeTransform {

  transform(value: string, size: number): unknown {
    return value
      .split(' ')
      .slice(0, isNaN(size) ? 1 : size)
      .map(n => n[0])
      .join('');
  }

}
