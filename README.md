Для запуска этого кода пришлось использовать параметры запуска в IDEA "--add-opens java.base/java.util=ALL-UNNAMED"
Поскольку с Java 9 hashMap является частью пакета base и не дает через рефлексию залезть внутрь и изменить флаг.

![image](https://github.com/user-attachments/assets/b72a6547-1460-4d8d-ad5a-f6e2dfec5731)
