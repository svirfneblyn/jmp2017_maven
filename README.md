# jmp2017_maven
 1. Прикрутить кеш второго уровня EHCACHE
    когда кеш только во вред
    from User - вытягиваешь список юзеров
    в базу идёт select * from User
    если кеш есть - select id from User - выгребет только ID-шники
    а потом будет будет лезть в кеш за каждым юзером
    если в кеше ничего нет - будет для каждого юзера делать отдельный SQL select * from User where id={id}
 
  2. Все виды связей
     + сохранение коллекции примитивных типов (List<String> внутри JPA-сущности)
    у тебя есть JPA-сущность, внутри которой одно из полей это List<String>
     остальные поля примитивных типов
  как это сохранить в JPA
 
  3. сортировка при вычитке из базу
      @OrderColumn
     @OrderBy
  + 4. Хранение иерархии наследования
     3 способа хранения иерархий наследования: joined, single table, table per class
  4. Native SQL
     @SqlResultSetMapping
     @NamedNativeQuery

  5. entity graphs - JPA 2.1
   по дефолту у тебя Lazy
   но для конкретного запроса ты хочешь вытянуть eager определённый граф
 
  6. Composite primary key
  - из нескольких примитивных полей
   несколько ID-шников
   @EmbeddedId
   @Embeddable
  
  7. Cascading
    CascadeType.ALL, CascadeType.REMOVE, CascadeType.MERGE
  8. Конвертеры @Converter
  
  9. read-only entities
  @Column(updatable = false)
  @Column(insertable = false)
  @OneToOne(optional = false)
  10. Validation
   @NotNull
   @Size(max = 40, min = 10)
   @Past - на дату
   @Future
   @Min(1000)
   @Max(2000)
   @Pattern(regexp = "[1-9][a-z][1-9]")
  приоритет
2 - связи
3 - наследование
4 - native sql
7 - cascading
1 - 2'nd level cache

    ===== Spring =====
   декларативное управление транзакциями
   @Transactional
    REQUIRES_NEW
    MANDATORY
    SUPPORTS
    NEVER
    NOT_SUPPORTED
    REQUIRED