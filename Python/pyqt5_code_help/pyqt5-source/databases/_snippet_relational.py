from PyQt5.QtSql import QSqlRelation, QSqlRelationalTableModel

self.model = QSqlRelationalTableModel(db=db)

relation = QSqlRelation('<related_table>', '<related_table_foreign_key_column', '<column_to_display>')
self.model.setRelation(<column>, relation)
